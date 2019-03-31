package com.maoqin.movie.controller;

import com.maoqin.movie.entity.RolePrice;
import com.maoqin.movie.entity.User;
import com.maoqin.movie.service.MovieUserService;
import com.maoqin.movie.service.RolePriceService;
import com.maoqin.movie.service.UserService;
import com.maoqin.movie.utils.BaseResp;
import com.maoqin.movie.utils.JWTUtil;
import com.maoqin.movie.utils.MaoqinObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

@Slf4j
@RestController
@RequestMapping("/movieUser")
public class MovieUserController  {
    @Autowired
    private MovieUserService movieUserService;
    @Autowired
    private UserService userService;
    @Autowired
    private RolePriceService rolePriceService;
    @PostMapping("insertMovieUser")
    public int insertMovieUser(String name,String movieTicket,BigDecimal price){
        return movieUserService.insertMovieUser(name,movieTicket,price);
    }
    @RequestMapping("buy")
    //接口优化 1.返回值改为对象 2.price字段用Bigdecimal 3.需要判断movieUserService.insertMovieUser结果是否成功，成功了才给用户更新余额userService.updateBalance
    //该接口需要登陆才能访问
    @RequiresAuthentication     //认证，记得要写
    @Transactional(rollbackFor = Exception.class)    //出现异常回滚
    public synchronized MaoqinObject buy(String movieTicket, HttpServletRequest request) throws Exception {
        //思路： 1.从request中拿到token 2.解密token得到username 3.根据username查询用户的角色 4.根据角色查询票价 5.购买电影票，插入信息包括票价
        String token = request.getHeader("token");     //得到请求用户的token 在header处
        String name = JWTUtil.getUsername(token);       //通过token得到用户名
        User user =userService.getUserByName(name);        //通过用户名得到用户表里用户的数据
        RolePrice rolePrice = rolePriceService.getRolePriceByRole(user.getRole());  //通过用户的角色来查询角色票价表里角色的数据
        BigDecimal price =rolePrice.getPrice();        //得到角色对应的票价

        if(user.getBalance().compareTo(price)<0){
            return MaoqinObject.ok("余额不足");
        }
        BigDecimal balance=user.getBalance().subtract(price);
        int updateResult = userService.updateBalance(name,balance);
        if (0==updateResult ){                                                            //需要判断movieUserService.insertMovieUser结果是否成功，成功了才给用户更新余额userService.updateBalance
            return MaoqinObject.ok("减余额失败，请重试");
        }
        if (updateResult>1){
            throw new Exception();
        }
        movieUserService.insertMovieUser(name,movieTicket,price);//在电影票用户表中插入用户名电影票票价，即完成购买电影票
        MaoqinObject maoqinObject=new MaoqinObject();
        maoqinObject.setMessage("购买成功");
        maoqinObject.setObject(balance);
        return maoqinObject;
    }
}

package com.maoqin.movie.controller;

import com.maoqin.movie.entity.User;
import com.maoqin.movie.service.UserService;
import com.maoqin.movie.utils.JWTUtil;
import com.maoqin.movie.utils.MaoqinObject;
import com.maoqin.movie.utils.StringTools;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login")
    public Map<String, Object> login(String name, String password) throws Exception {
        User user = userService.getUserByName(name);
        if (StringTools.isNullOrEmpty(user.getName())) {
            return null;
        } else if (user.getPassword().equals(password)) {
            String token = JWTUtil.sign(name);  //通过用户名解密token
            Map<String, Object> map = new HashMap<>();  //创建一个map为了接受数据
            map.put("msg", "登陆成功");    //向map里放元素
            map.put("token", token);        //向map里放元素
            return map;
        } else {
            return null;
        }
    }

    @PostMapping("getUserByName")
    public User getUserByName(String name) {
        User user = userService.getUserByName(name);
        return user;
    }

    @PostMapping("getUserByPage")
    public MaoqinObject getUserByPage(int pageNo, int pageSize) {
        int start = (pageNo-1)* pageSize;
        List<User> list = userService.getUserByPage(start, pageSize);
         MaoqinObject maoqinObject = new MaoqinObject();
        maoqinObject.setMessage("success");
         maoqinObject.setObject(list);
        return maoqinObject;
    }

    @PostMapping("insertUser")
//    @RequestMapping("insertUser")
    public int insertUser(String name, String password, String role) {
        return userService.insertUser(name, password, role);
    }

    @PostMapping("updateUser")
    public int updateUser(String name, String password) {
        return userService.updateUser(name, password);
    }

}


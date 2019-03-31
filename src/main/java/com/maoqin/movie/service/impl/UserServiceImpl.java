package com.maoqin.movie.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.maoqin.movie.dao.UserDao;
import com.maoqin.movie.entity.User;
import com.maoqin.movie.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements UserService {

    @Override
    public User getUserByName(String name) {
        return baseMapper.getUserByName(name);
    }

    @Override
    public List<User> getUserByPage(int pageNo, int pageSize) {
        return baseMapper.getUserByPage(pageNo,pageSize);
    }

    @Override
    public int insertUser(String name, String password, String role) {
        return baseMapper.insertUser(name,password,role);
    }

    @Override
    public int updateUser(String name, String password) {
        return baseMapper.updateUser(name,password);
    }

    @Override
    public int updateBalance(String name,BigDecimal balance) {
        return baseMapper.updateBalance(name,balance);
    }

}

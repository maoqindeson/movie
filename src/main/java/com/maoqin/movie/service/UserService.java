package com.maoqin.movie.service;

import com.baomidou.mybatisplus.service.IService;
import com.maoqin.movie.entity.User;

import java.math.BigDecimal;
import java.util.List;

public interface UserService extends IService<User> {
    User getUserByName(String name);
    List<User> getUserByPage(int pageNo, int pageSize);
    int insertUser(String name, String password,String role);
    int updateUser(String name, String password);
    int updateBalance(String name,BigDecimal balance);
}

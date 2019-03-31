package com.maoqin.movie.service;

import com.baomidou.mybatisplus.service.IService;
import com.maoqin.movie.entity.MovieUser;

import java.math.BigDecimal;

public interface MovieUserService extends IService<MovieUser> {
    int insertMovieUser(String name, String movieTicket,BigDecimal price);
}


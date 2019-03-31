package com.maoqin.movie.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.maoqin.movie.dao.MovieUserDao;
import com.maoqin.movie.entity.MovieUser;
import com.maoqin.movie.service.MovieUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service("movieUser")
public class MovieUserServiceImpl extends ServiceImpl<MovieUserDao, MovieUser> implements MovieUserService {

    @Override
    public int insertMovieUser(String name, String movieTicket,BigDecimal price) {
        return baseMapper.insertMovieUser(name,movieTicket,price);
    }
}


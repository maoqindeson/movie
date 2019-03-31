package com.maoqin.movie.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.maoqin.movie.entity.MovieUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface MovieUserDao extends BaseMapper<MovieUser> {
    int insertMovieUser(@Param("name")String name, @Param("movieTicket") String movieTicket, @Param("price")BigDecimal price);
}

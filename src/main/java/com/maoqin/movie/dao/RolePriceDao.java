package com.maoqin.movie.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.maoqin.movie.entity.RolePrice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolePriceDao extends BaseMapper<RolePrice> {
    RolePrice getRolePriceByRole(String role);
}


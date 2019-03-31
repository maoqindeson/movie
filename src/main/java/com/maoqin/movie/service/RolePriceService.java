package com.maoqin.movie.service;

import com.baomidou.mybatisplus.service.IService;
import com.maoqin.movie.entity.RolePrice;

public interface RolePriceService extends IService<RolePrice> {
    RolePrice getRolePriceByRole(String role);
}
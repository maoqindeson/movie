package com.maoqin.movie.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.maoqin.movie.dao.RolePriceDao;
import com.maoqin.movie.entity.RolePrice;
import com.maoqin.movie.service.RolePriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service("rolePriceService")
public class RolePriceServiceImpl extends ServiceImpl<RolePriceDao,RolePrice> implements RolePriceService {

    @Override
    public RolePrice getRolePriceByRole(String role) {
        return baseMapper.getRolePriceByRole(role);
    }
}

package com.maoqin.movie.controller;

import com.maoqin.movie.entity.RolePrice;
import com.maoqin.movie.service.RolePriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/rolePrice")
public class RolePriceController {
    @Autowired
    private RolePriceService rolePriceService;

    @RequestMapping("getRolePriceByRole")
    public RolePrice getRolePriceByRole(String role){
        RolePrice rolePrice = rolePriceService.getRolePriceByRole(role);
        return rolePrice;
    }
}

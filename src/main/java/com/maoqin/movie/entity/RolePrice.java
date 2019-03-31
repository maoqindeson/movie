package com.maoqin.movie.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.math.BigDecimal;

@TableName("tb_role_price")
@Data
public class RolePrice {
    @TableId
    private int id;
    private String role;
    private BigDecimal price;

}


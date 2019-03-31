package com.maoqin.movie.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.math.BigDecimal;
@Data
@TableName("tb_user")
public class User {
    @TableId
    private int id;
    private String name;
    private String password;
    private String role;
    private BigDecimal balance;
}

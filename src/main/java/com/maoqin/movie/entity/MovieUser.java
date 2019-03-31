package com.maoqin.movie.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.math.BigDecimal;
@Data
@TableName("tb_movie_user")
public class MovieUser {
    @TableId
    private int id;
    private String name;
    private String movieTicket;
    private BigDecimal price;

}

package com.maoqin.movie.utils.oss;

import lombok.Data;

import java.util.Date;

@Data
public class ActivityData {
    private Date created;
    private int id;
    private String name;
}

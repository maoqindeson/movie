package com.maoqin.movie.utils.oss;

import lombok.Data;

import java.util.List;

@Data
public class ActivityResponse {
    private int code;
    private List<ActivityData> data;
    public ActivityResponse()
    {
        this.code = 200;
    }
}

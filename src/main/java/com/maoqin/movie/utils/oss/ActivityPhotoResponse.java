package com.maoqin.movie.utils.oss;

import lombok.Data;

import java.util.List;

@Data
public class ActivityPhotoResponse {
    private int code;
    private List<ActivityPhotoData> data;
//    private int total;
}

package com.maoqin.movie.utils.oss;

import lombok.Data;

@Data
public class UploadPhotoResponse {
    private String code;
    private String message;
    private long timestamp;
}

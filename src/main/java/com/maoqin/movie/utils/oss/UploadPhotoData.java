package com.maoqin.movie.utils.oss;

import lombok.Data;

@Data
public class UploadPhotoData {
    private String oss_url;
    private String oss_filename;
    private String group_id;
}

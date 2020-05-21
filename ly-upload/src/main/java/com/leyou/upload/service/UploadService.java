package com.leyou.upload.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/5/19 15:20
 */
public interface UploadService {
    /**
     * 上传图片
     * @param file
     * @return
     */
    String uploadImage(MultipartFile file);
}

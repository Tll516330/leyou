package com.leyou.upload.serviceImpl;

import com.leyou.common.enums.ExceptionEnum;
import com.leyou.common.exception.LyException;
import com.leyou.upload.service.UploadService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * @author tll
 * @version 1.0.0
 * @date 2020/5/19 15:21
 */
@Service
@Slf4j
public class UploadServiceImpl implements UploadService {

    private static  final List<String> ALLOW_TYPE = Arrays.asList("image/jpeg","image/png","image/bmp");
    /**
     * 上传图片到本地磁盘
     * @param file
     * @return
     */
    @Override
    public String uploadImage(MultipartFile file) {

        try {
            //校验文件类型
            String contentType = file.getContentType();
            if (!ALLOW_TYPE.contains(contentType)){
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);

            }

            //校验文件内容
            BufferedImage image = ImageIO.read(file.getInputStream());
            if (image == null){
                //如果文件类型不是图片  则会返回一个null
                throw new LyException(ExceptionEnum.INVALID_FILE_TYPE);
            }
            //准备目标路径
            File dest = new File("D:\\photo\\upload",file.getOriginalFilename());
            //保存文件到本地
            file.transferTo(dest);

            //返回路径
            return "http://image.leyou.com/"+file.getOriginalFilename();
        } catch (Exception e) {
            //上传失败
            log.error("上传文件失败",e);
            throw new LyException(ExceptionEnum.UPLOAD_FILE_ERROR);
        }

    }
}

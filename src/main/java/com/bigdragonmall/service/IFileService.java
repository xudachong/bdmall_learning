package com.bigdragonmall.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @Author: XuJuLong<5 7 4 4 0 8 5 7 8 @ qq.com>
 * @Description:
 * @Date: Created in 16:54 2018/1/9
 * @
 */
public interface IFileService {

	String upload(MultipartFile file, String path);

}

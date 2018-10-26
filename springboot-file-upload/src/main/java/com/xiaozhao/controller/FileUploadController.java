package com.xiaozhao.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 文件上传控制器
 *
 * @author xiaozhao
 * @date 2018/10/24下午4:51
 */
@Controller
@RequestMapping("/hello")
public class FileUploadController {

    private static final Logger logger = LoggerFactory.getLogger(FileUploadController.class);
    private final String tempPath = "/Users/xiaozhao/Technology/temp/";

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    /**
     * 单文件上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/upload/single")
    @ResponseBody
    public Map<String, String> single(@RequestParam("singleFile") MultipartFile file) throws IOException {
        System.out.println("进入控制器上传方法");
        logger.info("[文件类型] - [{}]", file.getContentType());
        logger.info("[文件名称] - [{}]", file.getOriginalFilename());
        logger.info("[文件大小] - [{}]", file.getSize());
        Map<String, String> result = new HashMap<>(16);
        file.transferTo(new File(tempPath + file.getOriginalFilename()));
        result.put("contentType", file.getContentType());
        result.put("fileName", file.getOriginalFilename());
        result.put("fileSize", file.getSize() + "");
        return result;
    }


    @PostMapping("/upload/multi")
    @ResponseBody
    public List<Map<String, String>> multi(@RequestParam("file") MultipartFile[] files) throws IOException {
        if (files == null || files.length == 0) {
            return null;
        }
        List<Map<String, String>> results = new ArrayList<>();
        for (MultipartFile file : files) {
            // TODO Spring Mvc 提供的写入方式
            file.transferTo(new File(tempPath + file.getOriginalFilename()));
            Map<String, String> map = new HashMap<>(16);
            map.put("contentType", file.getContentType());
            map.put("fileName", file.getOriginalFilename());
            map.put("fileSize", file.getSize() + "");
            results.add(map);
        }
        return results;
    }

    @PostMapping("/upload/base64")
    @ResponseBody
    public void base64(String base64) throws IOException {
        // TODO BASE64 方式的 格式和名字需要自己控制（如 png 图片编码后前缀就会是 data:image/png;base64,）
        final File tempFile = new File(tempPath + "test.jpg");
        // TODO 防止有的传了 data:image/png;base64, 有的没传的情况
        String[] d = base64.split("base64,");
        final byte[] bytes = Base64Utils.decodeFromString(d.length > 1 ? d[1] : d[0]);
        FileCopyUtils.copy(bytes, tempFile);

    }

}

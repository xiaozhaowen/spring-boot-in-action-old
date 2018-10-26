package com.xiaozhao.storage;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 官网示例
 *
 * @author xiaozhao
 * @date 2018/10/25下午1:40
 */
@ConfigurationProperties("storage")
public class StorageProperties {
    /**
     * 保存文件的文件夹
     */
    private String location = "upload-dir";

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}

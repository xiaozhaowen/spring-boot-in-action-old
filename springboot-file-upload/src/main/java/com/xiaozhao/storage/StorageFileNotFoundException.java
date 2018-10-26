package com.xiaozhao.storage;

/**
 * 官网示例
 *
 * @author xiaozhao
 * @date 2018/10/25下午1:39
 */
public class StorageFileNotFoundException extends StorageException {
    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}


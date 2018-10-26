package com.xiaozhao.storage;

/**
 * 官网示例
 *
 * @author xiaozhao
 * @date 2018/10/25下午1:38
 */
public class StorageException extends RuntimeException {
    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }
}

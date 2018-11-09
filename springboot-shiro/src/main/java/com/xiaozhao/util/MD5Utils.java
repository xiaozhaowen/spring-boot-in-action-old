package com.xiaozhao.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 加密工具类，对shiro加密的一些封装
 * 比如对用户密码进行加密，使用用户名，密码和密钥的组合来生成一个密码串
 *
 * @author xiaozhao
 * @date 2018/11/7下午2:29
 */
public class MD5Utils {

    /**
     * 秘钥 加盐
     */
    private static final String SALT = "spider";

    /**
     * 算法名称
     */
    private static final String ALGORITH_NAME = "md5";

    /**
     * 加密次数
     */
    private static final int HASH_ITERATIONS = 2;


    /**
     * 对密码进行加密
     *
     * @param pswd
     * @return
     */
    public static String encrypt(String pswd) {
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
        return newPassword;
    }

    /**
     * 对用户名，密码，盐的组合加密
     *
     * @param username
     * @param pswd
     * @return
     */
    public static String encrypt(String username, String pswd) {
        String newPassword = new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username + SALT),
                HASH_ITERATIONS).toHex();
        return newPassword;
    }


    /**
     * 简单加密
     *
     * @param password
     * @return
     */
    public static String simpleEncrypt(String password) {
        Md5Hash md5Hash = new Md5Hash(password, SALT);
        System.out.println(md5Hash.toString());
        return md5Hash.toString();
    }

    public static void main(String[] args) {
        System.out.println(encrypt("xiaozhao", "123456"));
    }
}

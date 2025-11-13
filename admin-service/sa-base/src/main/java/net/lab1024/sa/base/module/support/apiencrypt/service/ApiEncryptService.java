package net.lab1024.sa.base.module.support.apiencrypt.service;

/**
 * 接口加密、解密 Service
 *
 */

public interface ApiEncryptService {

    /**
     * 解密
     * @param data
     * @return
     */
    String decrypt(String data);

    /**
     * 加密
     *
     * @param data
     * @return
     */
    String encrypt(String data);

}

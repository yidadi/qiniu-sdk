package com.git.yi.qiniu.vo;

/**
 * Created by yidadi on 17-5-31.
 */
public class AuthVo {
    private String accessKey;
    private String secretKey;
    /**区域
     * 0 华东机房相关域名
     * 1 华北机房相关域名
     * 2 华南机房相关域名*/
    private Integer zero;
    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public Integer getZero() {
        return zero;
    }

    public void setZero(Integer zero) {
        this.zero = zero;
    }
}

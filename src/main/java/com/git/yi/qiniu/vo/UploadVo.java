package com.git.yi.qiniu.vo;

/**
 * Created by yidadi on 17-5-24.
 */
public class UploadVo {
    /**自定义上传的文件名*/
    private String fileName;
    /**七牛的路径名*/
    private String bucket;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}

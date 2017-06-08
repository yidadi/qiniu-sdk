package com.git.yi.qiniu.vo;

import java.io.InputStream;

/**
 * Created by yidadi on 17-5-24.
 */
public class InputStreamVo extends UploadVo{
    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }
}

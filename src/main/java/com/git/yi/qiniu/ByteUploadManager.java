package com.git.yi.qiniu;

import com.git.yi.qiniu.vo.ByteVo;
import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yidadi on 17-5-24.
 */
@Component
public class ByteUploadManager{
    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private Auth auth;
    /**
     * @param byteVo
     * @return
     */
    public String upload(ByteVo byteVo) {
        try {
            String upToken = auth.uploadToken(byteVo.getBucket());
            try {
                Response response = uploadManager.put(byteVo.getBytes(), byteVo.getFileName(), upToken);
                //解析上传成功的结果
                DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return putRet.key;
            } catch (QiniuException ex) {
                ex.printStackTrace();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}

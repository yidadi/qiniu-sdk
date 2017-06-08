package com.git.yi.qiniu;

import com.git.yi.qiniu.vo.InputStreamVo;
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
public class InputStreamUploadManager{
    @Autowired
    private UploadManager uploadManager;
    @Autowired
    private Auth auth;
    /**
     *
     * @param inputStreamVo
     * @return
     */
    public String upload(InputStreamVo inputStreamVo) {
        try {
            String upToken = auth.uploadToken(inputStreamVo.getBucket());
            try {
                Response response = uploadManager.put(inputStreamVo.getInputStream(),inputStreamVo.getFileName(),upToken,null, null);
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

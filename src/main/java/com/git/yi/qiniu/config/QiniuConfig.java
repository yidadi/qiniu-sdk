package com.git.yi.qiniu.config;

import com.git.yi.qiniu.vo.AuthVo;
import com.qiniu.common.Zone;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.qiniu.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * Created by yidadi on 17-5-31.
 */
@Configuration
public class QiniuConfig {
    @Autowired
    private Environment env;

    @Bean
    public Auth auth(AuthVo authVo){
        Auth auth = Auth.create(authVo.getAccessKey(), authVo.getSecretKey());
        return auth;
    }

    @Bean
    public UploadManager uploadManager(AuthVo authVo){
        com.qiniu.storage.Configuration cfg = null;
        if(authVo.getZero() == 0){
            cfg = new com.qiniu.storage.Configuration(Zone.zone0());
        }else if(authVo.getZero() == 1){
            cfg = new com.qiniu.storage.Configuration(Zone.zone1());
        }else if(authVo.getZero() == 2){
            cfg = new com.qiniu.storage.Configuration(Zone.zone2());
        }else{
            throw new IllegalArgumentException("the zero not access,zero="+authVo.getZero());
        }
        return new UploadManager(cfg);
    }

    @Bean
    public AuthVo authVo(){
        AuthVo authVo = new AuthVo();
        String accessKey = env.getProperty("git.qiniu.accessKey");
        String secretKey = env.getProperty("git.qiniu.secretKey");
        Integer zero = env.getProperty("git.qiniu.zero",Integer.TYPE,0);
        if(StringUtils.isNullOrEmpty(accessKey)){
            throw new NullPointerException("the git.qiniu.accessKey is empty or null");
        }
        if(StringUtils.isNullOrEmpty(secretKey)){
            throw new NullPointerException("the git.qiniu.secretKey is empty or null");
        }
        authVo.setAccessKey(accessKey);
        authVo.setSecretKey(secretKey);
        authVo.setZero(zero);
        return authVo;
    }
}

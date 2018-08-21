package com.springboot.dubbo.demo.common.bean.oss;

import com.springboot.dubbo.demo.common.util.StringUtil;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Benson on 2018/3/28.
 */
@Component
@ConfigurationProperties(prefix="spring.oss")
public class OSSConfig {

    private String accessId;
    private String accessKey;
    private String endpoint;
    private String bucket;
    /**
     * policy 的有效期，单位秒
     */
    private long policyExpireTime;

    /**
     * 根目录
     */
    private String rootDir;



    public String getAccessId() {
        return accessId;
    }

    public void setAccessId(String accessId) {
        this.accessId = accessId;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public long getPolicyExpireTime() {
        return policyExpireTime;
    }

    public void setPolicyExpireTime(long policyExpireTime) {
        this.policyExpireTime = policyExpireTime;
    }

    public String getRootDir() {
        return StringUtil.isBlank(rootDir) ? "" : (!rootDir.endsWith("/") ? rootDir + "/" : rootDir);
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }

}

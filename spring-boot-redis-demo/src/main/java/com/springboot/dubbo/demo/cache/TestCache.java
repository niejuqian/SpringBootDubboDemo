package com.springboot.dubbo.demo.cache;

import com.springboot.dubbo.demo.common.cache.StringCache;
import org.springframework.stereotype.Component;

/**
 * Created by niejiuqian on 2018/8/27.
 */
@Component
public class TestCache extends StringCache {

    public void save(String key,String val) {
        put(key,val);
    }


    public String findCache(String key) {
        return get(key);
    }

    @Override
    public void invalid(String key) {
        remove(key);
    }

    @Override
    protected String getPrefix() {
        return "testcache";
    }

    @Override
    protected Integer getTimeout() {
        return RedisTime.MINUTE;
    }
}

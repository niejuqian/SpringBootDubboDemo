package com.springboot.dubbo.demo.consumer.druid;

import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.context.annotation.Profile;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;

/**
 * Created by laonie on 2018/9/16.
 */
@WebFilter(
        filterName = "druidWebStatFilter",
        urlPatterns = "/*",
        initParams = {
                @WebInitParam(name = "exclusions",value = "*.js,*.gif,*.jpg,*.bmp,*.png,*.css,*.ico,/druid/*")
        })
@Profile({"test"})
public class DruidStatFilter extends WebStatFilter{
}

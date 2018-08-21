package com.springboot.dubbo.demo.consumer;

import com.springboot.dubbo.demo.common.web.AppExceptionHandlerResolver;
import com.springboot.dubbo.demo.common.web.LogParamInterceptor;
import com.springboot.dubbo.demo.common.web.RequestBodyReadFilter;
import com.springboot.dubbo.demo.common.web.ResponseBodyWrapperHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * web配置
 * @author niejiuqian
 * @date 2018/8/21
 */
public class ConsumerWebConfig extends WebMvcConfigurerAdapter{

    // 自定义请求参数日志打印
    @Autowired
    private LogParamInterceptor logParamInterceptor;

    //全局自定义异常处理
    @Autowired
    private AppExceptionHandlerResolver appExceptionHandlerResolver;

    //出参封装处理
    @Autowired
    private ResponseBodyWrapperHandler responseBodyWrapperHandler;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        addAll(registry, logParamInterceptor);
    }

    private InterceptorRegistration addAll(InterceptorRegistry registry, HandlerInterceptor adapter) {
        return registry.addInterceptor(adapter).addPathPatterns("/**");
    }

    @Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        super.addReturnValueHandlers(returnValueHandlers);
        returnValueHandlers.add(responseBodyWrapperHandler);
    }

    @Override
    public void extendHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        super.extendHandlerExceptionResolvers(exceptionResolvers);
        exceptionResolvers.add(appExceptionHandlerResolver);
    }

    @Bean
    public FilterRegistrationBean requstBodyReadFilter(){
        FilterRegistrationBean registration = new FilterRegistrationBean();
        RequestBodyReadFilter signValidateFilter = new RequestBodyReadFilter();
        registration.setFilter(signValidateFilter);
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;
    }
}

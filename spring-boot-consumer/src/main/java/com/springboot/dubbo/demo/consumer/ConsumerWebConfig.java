package com.springboot.dubbo.demo.consumer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.springboot.dubbo.demo.common.web.AppExceptionHandlerResolver;
import com.springboot.dubbo.demo.common.web.LogParamInterceptor;
import com.springboot.dubbo.demo.common.web.RequestBodyReadFilter;
import com.springboot.dubbo.demo.common.web.ResponseBodyWrapperHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
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

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        super.configureMessageConverters(converters);
        //1.需要先定义一个 convert 转换消息的对象;
        FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
        List<MediaType> supportedMediaTypes = new ArrayList<MediaType>();
        supportedMediaTypes.add(MediaType.parseMediaType("text/html;charset=UTF-8"));
        supportedMediaTypes.add(MediaType.parseMediaType("application/json"));
        fastConverter.setSupportedMediaTypes(supportedMediaTypes);
        //2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        // 忽略对象属性中的null值
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
        //3、在convert中添加配置信息.
        fastConverter.setFastJsonConfig(fastJsonConfig);
        //4、将convert添加到converters当中.
        converters.add(fastConverter);
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

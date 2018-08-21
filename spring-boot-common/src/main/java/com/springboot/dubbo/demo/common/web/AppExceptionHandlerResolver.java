package com.springboot.dubbo.demo.common.web;

import com.springboot.dubbo.demo.common.util.KeepJsonUtil;
import com.springboot.dubbo.demo.common.util.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by niejiuqian on 2017/9/15.
 * 统一异常处理
 */
@Component
public class AppExceptionHandlerResolver implements HandlerExceptionResolver {

    private static Logger logger = LoggerFactory.getLogger(AppExceptionHandlerResolver.class);

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        JsonResponse jsonResponse = null;
        if (null != ex) {
            logger.error(ex.getMessage(),ex);
            if (ex instanceof AppException) {
                AppException appException = (AppException)ex;
                ResponseHeader responseHeader = null;
                if (appException.getResponseHeader() != null) {
                    responseHeader = appException.getResponseHeader();
                } else {
                    responseHeader = StandardResponseHeader.ERROR;
                }
                jsonResponse = WebUtil.errorJsonResponseCustomMsg(appException.getMessage(),responseHeader);
            } else {
                jsonResponse = WebUtil.errorJsonResponse(StandardResponseHeader.ERROR);
            }
        }else {
            jsonResponse = WebUtil.errorJsonResponse(StandardResponseHeader.ERROR);
        }
        String resultJson = KeepJsonUtil.beanToJson(jsonResponse);
        logger.info(" \n返回客户端json :\n "+ resultJson);
        ResponseHelper.write(response, resultJson);
        return new ModelAndView();
    }
}

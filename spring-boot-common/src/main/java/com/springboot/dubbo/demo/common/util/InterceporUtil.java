package com.springboot.dubbo.demo.common.util;

import com.springboot.dubbo.demo.common.annos.NotPrintLog;
import org.springframework.core.MethodParameter;
import org.springframework.web.method.HandlerMethod;

/**
 * 拦截器帮助类
 *
 * @author 6213
 * @date 2018/6/14
 */
public class InterceporUtil {

    /**
     * 是否需要打印日志
     * @param handler
     * @return
     */
    public static boolean isPrinterLog(Object handler){
        if (null == handler) return true;
        NotPrintLog notPrintLog = null;
        if (null!= handler && handler instanceof HandlerMethod) {
            notPrintLog = ((HandlerMethod) handler).getMethod().getAnnotation(NotPrintLog.class);
        }
        return (null == notPrintLog);
    }


    /**
     * 是否需要打印日志
     * @param returnType
     * @return
     */
    public static boolean isPrinterLog(MethodParameter returnType){
        if (null == returnType) return true;
        NotPrintLog notPrintLog = returnType.getMethodAnnotation(NotPrintLog.class);
        return (null == notPrintLog);
    }
}

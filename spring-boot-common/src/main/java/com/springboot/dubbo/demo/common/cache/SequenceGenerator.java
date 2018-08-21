package com.springboot.dubbo.demo.common.cache;

import com.springboot.dubbo.demo.common.util.TimeUtil;
import org.springframework.stereotype.Component;

/**
 *  订单号的生成器
 * Created by linyh on 2017/7/26.
 */
@Component
public class SequenceGenerator extends StringCache{

    private static final String ORDER_KEY = "order";

    /**
     * 获取订单号
     * @return
     */
    public String generateOrder(){
        Long number = increment(ORDER_KEY);
        if(number%1000 == 0){//取模1000时，重置为0
            put(ORDER_KEY, "0");
        }
        return TimeUtil.getMilliDatetime()
               + String.format("%04d", number.longValue()); //4位数，前面补0
    }

    @Override
    protected String getPrefix() {
        return "sequence";
    }

    @Override
    protected Integer getTimeout() {
        return null;
    }

    @Override
    public void invalid(String key) {

    }
}

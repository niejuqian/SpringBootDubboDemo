package com.springboot.dubbo.demo.common.dto;

import com.springboot.dubbo.demo.common.util.StringUtil;
import com.springboot.dubbo.demo.common.util.TimeUtil;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Benson on 2018/3/28.
 */
public abstract class Dto implements Serializable{

    /** 默认第几页 */
    protected static final Integer PAGE_NUMBER = 1;

    /** 默认每页显示条数 */
    protected static final Integer PAGE_SIZE = 10;

    protected String blankWhenNull(Object o){
        return o == null ? null : o.toString();
    }

    protected Integer blankWhenNullOfInteger(Object o){
        return o != null && StringUtil.isNotNil(o.toString()) ? Integer.parseInt(o.toString()) : null;
    }

    protected Integer blankWhenNullOfInteger(Object o,int defaultVal){
        return o != null && StringUtil.isNotNil(o.toString()) ? Integer.parseInt(o.toString()) : defaultVal;
    }

    protected Date blankWhenNullOfDate(Object o){
        return o == null ? null : (StringUtil.isBlank(o.toString()) ? null : (Date)o);
    }

    protected Date blankWhenNullOfDateTime(Object o){
        if (null == o) return null;
        return TimeUtil.parseDatetime(o.toString());
    }

    protected BigDecimal blankWhenNullOfBigDecimal(Object o) {
        return o == null ? null : new BigDecimal(o.toString());
    }

    protected Boolean blankWhenNullOfBoolean(Object o) {
        return null == o ? Boolean.FALSE : (Boolean) o;
    }

    protected Boolean blankWhenNullOfIntegerToBoolean(Object o) {
        if (null == o) {
            return false;
        }
        if (o instanceof Boolean) {
            return (Boolean) o;
        }
        return ("0".equals(o.toString()) ? Boolean.FALSE : Boolean.TRUE);
    }

    protected Integer blankWhenNullOfDoubleToInteger(Object o) {
        Double d = null;
        if(o != null && StringUtil.isNotNil(o.toString()) ){
            d = Double.parseDouble(o.toString());
        }
        return d != null? d.intValue(): null;
    }

    protected Integer blankWhenNullOfBigDecimalInteger(Object o) {
        BigDecimal bigDecimal = blankWhenNullOfBigDecimal(o);
        return null == bigDecimal ? null : bigDecimal.intValue();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

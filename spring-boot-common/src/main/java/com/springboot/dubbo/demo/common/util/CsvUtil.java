package com.springboot.dubbo.demo.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dengjihai
 * @create 2018-03-30
 **/
public class CsvUtil {

    private static Logger logger= LoggerFactory.getLogger(CsvUtil.class);

    public static List<String> parseCsv(String filePath){
        logger.info("解析文件名字:{}",filePath);
        List<String> stringList = new ArrayList<>();
        File file = new File(filePath);
        //解决中文乱码
        InputStreamReader isr=null;
        BufferedReader buff =null;
        try {
            isr = new InputStreamReader(new FileInputStream(file), "GBK");
            buff = new BufferedReader(isr);
            String line=null;
            while ((line=buff.readLine())!=null) {
                //去除`
                String replace = line.replace("`", "");
                stringList.add(replace);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(isr!=null) {
                    isr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(buff!=null) {
                    buff.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringList;

    }
}

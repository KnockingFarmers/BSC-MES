package com.github.ganlong.commons.uitl;

import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

/**
 * @Author KnockingFarmers
 * @Date 2022/12/13 9:00
 * @PackageName:com.github.ganlong.commons.uitl
 * @ClassName: UniqueNumberUtil
 * @Description: TODO
 * @Version 1.0
 */
public class UniqueNumberUtil {



    /**
     * 取时间戳后8位
     */
    private static final int TIMESTAMP_LENGTH = 8;

    /**
     * 无参数生成订单号
     * @return OrderNum
     */
    public static String generateUniqueNum(){

        return getDateTime()+getRandomCode();
    }

    /**
     * 根据传入的对象获取对象的参数生成订单号
     * @return OrderNum
     */
    public synchronized static String generateUniqueNum(String paramObject) throws NoSuchFieldException, IllegalAccessException {

        byte[] bytes = paramObject.getBytes(StandardCharsets.UTF_8);
        int paramToByte = bytes.length + bytes[bytes.length - 1];

        return generateUniqueNum()+paramToByte;
    }

    /**
     * 取时间戳后8位
     * @return
     */
    private static String getDateTime(){
        String dateStr = String.valueOf(System.currentTimeMillis());
        return dateStr.substring(dateStr.length() - TIMESTAMP_LENGTH);
    }

    /**
     * 生成四位随机数
     * @return
     */
    public static String getRandomCode(){
        return String.valueOf(String.format("%04d", (int) (Math.random() * 9999)));
    }

}

package org.luoke.ice.util.core;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * JSON 工具类，对 {@link  ObjectMapper} 进行封装
 * @author luoke 2023/6/15 12:26
 */
public class JsonUtil {
    public static final ObjectMapper objectMapper = new ObjectMapper();

    public static String toJson(Object value) {
        try {
            return objectMapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] toBytes(Object value) {
        try {
            return objectMapper.writeValueAsBytes(value);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 将 JSON 字符串转换为对象
     * @param jsonStr JSON 字符串
     * @param targetClass 目标对象
     * @param <T> 目标对象的类型
     * @return 转换后的目标对象
     */
    public static <T> T parse(String jsonStr, Class<T> targetClass) {
        try {
            return objectMapper.readValue(jsonStr, targetClass);
        } catch (JsonProcessingException e) {
//            log.info("JSON 解析异常：{}", e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }


    /**
     * 将字节数组转换为对象
     * @param bytes 字节数组
     * @param targetClass 目标对象
     * @param <T> 目标对象的类型
     * @return 转换后的目标对象
     */
    public static <T> T parseBytes(byte[] bytes, Class<T> targetClass) {
        try {
            return objectMapper.readValue(bytes, targetClass);
        } catch (IOException e) {
//            log.info("JSON 解析异常：{}", e.getMessage(), e);
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}

package org.luoke.ice.util.core.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.annotation.*;

/**
 * 该注解标注在 Bean 的属性或方法上，使用 {@link ByteArrayJsonSerializer} 序列化器将 {@link byte[]} 序列化为 {@link  Object} 对象.
 * <p>Example:</p>
 * <pre>
 *     {@code
 *     public class UserVO {
 *         //  返回到前端时会使用 {@link ObjectMapper#readValue(byte[], Class)} 将数组转为 {@link Object}对象
 *         @ByteJson
 *         byte[] result;
 *     }
 *     }
 * </pre>
 * @author luoke 2023/6/21 13:45
 * @see ByteArrayJsonSerializer
 */
@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ByteJson {


}

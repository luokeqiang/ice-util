package org.luoke.ice.util.core.collection;

/**
 * 数组工具类
 * @author luoke
 * @date 2022/7/26 23:07
 */
public class ArrayUtil {

    /**
     * 数组是否为空
     * @param <T>   数组元素类型
     * @param array 数组
     * @return 是否为空
     */
    public static <T> boolean isEmpty(T[] array) {
        return array == null || array.length == 0;
    }
}

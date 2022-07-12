package org.luoke.ice.util.core.collection;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 集合工具类
 *
 * @author luoke
 * @date 2022/7/12 10:11
 */
public class CollectionUtil {
    public <K,V> Map<K,V> listToMap(List<Map<K,V>>mapList,K key) {
        if (key == null) {
            throw new NullPointerException("key must not be null value");
        }
        if (mapList == null) {
            return null;
        }

    }
}

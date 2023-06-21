package org.luoke.ice.util.core.collection;

import org.luoke.ice.util.common.annotation.Nullable;
import org.luoke.ice.util.core.lang.OptionHelper;

import java.util.*;
import java.util.function.Function;

/**
 * 集合工具类
 *
 * @author luoke
 * @date 2022/7/12 10:11
 */
public class CollectionUtil {
    @Nullable
    public static <V> Map<Object, List<V>> listToMap(Iterable<V> mapList, Function<V,Object> keyFunction) {
        if (keyFunction == null) {
            throw new NullPointerException("key must not be null value");
        }
        if (mapList == null) {
            return new LinkedHashMap<>();
        }

        Map<Object, List<V>> resultMap = new LinkedHashMap<>();
        mapList.forEach(mapItem -> resultMap.computeIfAbsent(keyFunction.apply(mapItem), k -> new ArrayList<>()).add(mapItem));
        return resultMap;
    }
    @Nullable
    public static Map<Object, List<Map<String, Object>>> listToMap2(List<Map<String,Object>>mapList,String key) {
        if (key == null) {
            throw new NullPointerException("key must not be null value");
        }
        if (mapList == null) {
            return new HashMap<>();
        }

        Map<Object, List<Map<String, Object>>> resultMap = new HashMap<>();
        mapList.forEach(mapItem -> resultMap.compute(mapItem.get(key),(k1, list) -> OptionHelper
                .ofNullable(list)
                .orElseDo(ArrayList::new)
                .ifPresentDo(mapList1 -> mapList1.add(mapItem))
                .get()));
        return resultMap;
    }
}

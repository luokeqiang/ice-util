package org.luoke.ice.util.core.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author luoke
 * @date 2022/7/26 23:07
 */
public class ListUtil {

    /**
     *  合并多个集合为一个可被修改的集合
     * @param combineList 需要合并的集合
     * @param <T> 类型
     * @return 可被修改的集合
     */
    @SafeVarargs
    public static <T> List<T> combine(List<T>... combineList) {
        return combine(false, combineList);
    }

    /**
     *  合并多个集合为一个不可被修改的集合
     * @param combineList 需要合并的集合
     * @param <T> 类型
     * @return 不可被修改的集合
     */
    @SafeVarargs
    public static <T> List<T> combineImmutable(List<T>... combineList) {
        return combine(true, combineList);
    }

    @SafeVarargs
    public static <T> List<T> combine(boolean immutable, List<T>... combineList) {
        if (ArrayUtil.isEmpty(combineList)) {
            return immutable ? Collections.emptyList() :new ArrayList<>();
        }
        final List<T> combinedList = new ArrayList<>(combineList[0]);
        for (int i = 1; i < combineList.length; i++) {
            combinedList.addAll(combineList[i]);
        }
        return immutable ? Collections.unmodifiableList(combinedList) : combinedList;
    }

    public static void main(String[] args) {
        List<String> jf = new ArrayList<>();
        jf.add("Hello");

        List<String> list2 = new ArrayList<>();
        list2.add("World");

        final List<String> combine = combine(jf, list2);

    }
}

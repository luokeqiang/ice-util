package org.luoke.ice.util.core.collection;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luoke
 * @date 2022/7/12 11:11
 */
class CollectionUtilTest {

    @Test
    void listToMap() {
//        assertNull(CollectionUtil.listToMap(null,"null"));
        List<Map<String, Object>> list = new ArrayList<>() {{
            add(new HashMap<>() {{
                put("school", "xf");
                put("stu", "luoke");
            }});
            add(new HashMap<>() {{
                put("school", "xf");
                put("stu", "luo");
            }});
            add(new HashMap<>() {{
                put("school", "es");
                put("stu", "bo");
            }});
            add(new HashMap<>() {{
                put("school", "dj");
                put("stu", "uo");
            }});
        }};
        final Map<Object, List<Map<String, Object>>> school = CollectionUtil.listToMap(list, item -> item.get("school"));
        school.forEach((k,v) -> System.out.println(k+":"+v));
    }
    @Test
    void listToMap2() {
//        assertNull(CollectionUtil.listToMap(null,"null"));
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>() {{
            add(new HashMap<String,Object>() {{
                put("school","xf");
                put("stu","luoke");
            }});
            add(new HashMap<String,Object>() {{
                put("school","xf");
                put("stu","luo");
            }});
            add(new HashMap<String,Object>() {{
                put("school","es");
                put("stu","bo");
            }});
            add(new HashMap<String,Object>() {{
                put("school","dj");
                put("stu","uo");
            }});
        }};
        final Map<Object, List<Map<String, Object>>> school = CollectionUtil.listToMap2(list, "school");
        school.forEach((k,v) -> System.out.println(k+":"+v));
    }
}
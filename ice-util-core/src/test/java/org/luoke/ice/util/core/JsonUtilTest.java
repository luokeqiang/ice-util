package org.luoke.ice.util.core;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luoke 2023/6/15 13:42
 */
class JsonUtilTest {
    @Test
    void toJson() {
        Map<String, Integer> map = Map.of("one", 1, "two", 2);
        System.out.println(JsonUtil.toJson(map));
    }

    @Test
    void parse() {
        String str = "{\"one\":1,\"two\"";
        System.out.println(JsonUtil.parse(str, Map.class));
    }
}
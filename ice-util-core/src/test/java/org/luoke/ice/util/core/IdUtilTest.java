package org.luoke.ice.util.core;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luoke 2023/6/15 12:18
 */
class IdUtilTest {

    @AfterEach
    void tearDown() {
        IdUtil.clearAutoIncrementThreadLocal();
    }

    @Test
    void autoIncrement() {
        for (int i = 0; i < 100; i++) {
            assertEquals(i, IdUtil.autoIncrement());
        }
    }

    @Test
    void testAutoIncrement() {
        for (int i = 10; i < 100; i++) {
            assertEquals(i, IdUtil.autoIncrement(10));
        }
    }
}
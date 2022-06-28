package org.luoke.ice.util.core.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author luoke
 * @date 2022/6/28 15:50
 * @see MathUtil
 */
class MathUtilTest {

    @Test
    void mid() {
        assertEquals(2, MathUtil.mid(2, 1, 3));
        assertEquals(15, MathUtil.mid(10, 30, 15));
    }
}
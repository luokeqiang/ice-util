package org.luoke.ice.util.core;

import java.util.concurrent.atomic.AtomicLong;

/**
 * ID 生成器工具类, 生成常用随机 ID，或自增 ID
 *
 * @author luoke 2023/6/15 11:35
 */
public class IdUtil {
    /**
     * ID 自增 ThreadLocal
     */
    private static final ThreadLocal<AtomicLong> AUTO_INCREMENT_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取一个线程内自增的 ID，从 0 开始
     * @return 自增 ID
     */
    public static long autoIncrement() {
        initAutoIncrementThreadLocal(0);
        return AUTO_INCREMENT_THREAD_LOCAL.get().getAndIncrement();
    }

    /**
     * 获取一个线程内自增的 ID
     * @param initValue 初始 ID
     * @return 自增 ID
     */
    public static long autoIncrement(long initValue) {
        initAutoIncrementThreadLocal(initValue);
        return AUTO_INCREMENT_THREAD_LOCAL.get().getAndIncrement();
    }

    private static void initAutoIncrementThreadLocal(long initValue) {
        if (AUTO_INCREMENT_THREAD_LOCAL.get() == null) {
            AUTO_INCREMENT_THREAD_LOCAL.set(new AtomicLong(initValue));
        }
    }

    /**
     * 清除当前线程内的自增 ThreadLocal 值
     */
    public static void clearAutoIncrementThreadLocal() {
        AUTO_INCREMENT_THREAD_LOCAL.remove();
    }
}

package org.luoke.ice.util.common.annotation;

import java.lang.annotation.*;

/**
 * 标识可以为空
 * @author luoke
 * @date 2022/7/12 10:24
 */
@Documented
@Target({ElementType.METHOD,ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface Nullable {
}

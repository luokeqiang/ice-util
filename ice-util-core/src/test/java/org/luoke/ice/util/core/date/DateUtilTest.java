package org.luoke.ice.util.core.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  {@link DateUtil} 测试类
 * @author luoke
 * @date 2022/5/31 17:59
 */
class DateUtilTest {

    @Test
    void formatLocalDateTime() {
        final String format = DateUtil.format(LocalDateTime.now(), DatePattern.NORM_DATETIME_PATTERN);
        assertNotNull(format);
        System.out.println(format);
    }

    @Test
    void testFormatLocalDate() {
        final String format = DateUtil.format(LocalDate.now(), DatePattern.NORM_DATE_PATTERN);
        assertNotNull(format);
        System.out.println(format);
    }

    @Test
    void testFormatLocalTime() {
        final String format = DateUtil.format(LocalTime.now(), DatePattern.NORM_TIME_PATTERN);
        assertNotNull(format);
        System.out.println(format);
    }

    @Test
    void testFormatDate() {
        final String format = DateUtil.format(new Date(), DatePattern.NORM_DATETIME_PATTERN);
        assertNotNull(format);
        System.out.println(format);
    }

    @Test
    void parseLocalDateTime() {
        String text = "2022-06-01 08:56:23";
        final LocalDateTime localDateTime = DateUtil.parseLocalDateTime(text, DatePattern.NORM_DATETIME_PATTERN);
        assertNotNull(localDateTime);
        System.out.println(localDateTime);
    }

    @Test
    void parseLocalDate() {
        String text = "2022-06-01";
        final LocalDate localDateTime = DateUtil.parseLocalDate(text, DatePattern.NORM_DATE_PATTERN);
        assertNotNull(localDateTime);
        System.out.println(localDateTime);
    }

    @Test
    void parseLocalTime() {
        String text = "08:56:23";
        final LocalTime localDateTime = DateUtil.parseLocalTime(text, DatePattern.NORM_TIME_PATTERN);
        assertNotNull(localDateTime);
        System.out.println(localDateTime);
    }

    @Test
    void parseDate() {
        String text = "2022-06-01 08:56:23";
        final Date localDateTime = DateUtil.parseDate(text, DatePattern.NORM_DATETIME_PATTERN);
        assertNotNull(localDateTime);
        System.out.println(localDateTime);
    }
}
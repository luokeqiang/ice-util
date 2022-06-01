package org.luoke.ice.util.core.date;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  {@link DateConverter} 测试类
 * @author luoke
 * @date 2022/5/31 17:31
 */
class DateConverterTest {

    @Test
    void localDateTimeToDate() {
        final Date date = DateConverter.localDateTimeToDate(LocalDateTime.now());
        assertNotNull(date);
        System.out.println(date);
    }

    @Test
    void localDateToDate() {
        final Date date = DateConverter.localDateToDate(LocalDate.now());
        assertNotNull(date);
        System.out.println(date);
    }

    @Test
    void localTimeToDate() {
        final Date date = DateConverter.localTimeToDate(LocalTime.now());
        assertNotNull(date);
        System.out.println(date);
    }

    @Test
    void dateToLocalDateTime() {
        final LocalDateTime localDateTime = DateConverter.dateToLocalDateTime(new Date());
        assertNotNull(localDateTime);
        System.out.println(localDateTime);
    }

    @Test
    void dateToLocalDate() {
        final LocalDate localDate = DateConverter.dateToLocalDate(new Date());
        assertNotNull(localDate);
        System.out.println(localDate);
    }

    @Test
    void dateToLocalTime() {
        final LocalTime localDateTime = DateConverter.dateToLocalTime(new Date());
        assertNotNull(localDateTime);
        System.out.println(localDateTime);
    }
}
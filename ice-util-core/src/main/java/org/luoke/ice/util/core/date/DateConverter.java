package org.luoke.ice.util.core.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

/**
 * 日期格式转化器
 * @author luoke
 * @date 2022/5/31 17:15
 * @see Date
 * @see LocalDateTime
 * @see LocalDate
 * @see LocalTime
 */
public class DateConverter {
    private DateConverter() {}

    /**
     *  将 {@link LocalDateTime} 转换为 {@link Date} 对象
     * @param localDateTime {@link LocalDateTime} 对象
     * @return {@link Date} 对象 or null
     */
    public static Date localDateTimeToDate(LocalDateTime localDateTime) {
        return Optional.ofNullable(localDateTime)
                .map(ldt -> Date.from(ldt.atZone(ZoneId.systemDefault()).toInstant()))
                .orElse(null);
    }

    /**
     *  将 {@link LocalDate} 转换为 {@link Date} 对象
     * @param localDate {@link LocalDate} 对象
     * @return {@link Date} 对象 or null
     */
    public static Date localDateToDate(LocalDate localDate) {
        return localDateTimeToDate(Optional.ofNullable(localDate).map(LocalDate::atStartOfDay).orElse(null));
    }

    /**
     *  将 {@link LocalTime} 转换为 {@link Date} 对象
     * @param localTime {@link LocalTime} 对象
     * @return {@link Date} 对象 or null
     */
    public static Date localTimeToDate(LocalTime localTime) {
        return localDateTimeToDate(Optional.ofNullable(localTime).map(lt -> lt.atDate(LocalDate.now())).orElse(null));
    }

    /**
     *  将 {@link Date} 转换为 {@link LocalDateTime} 对象
     * @param date {@link Date} 对象
     * @return {@link LocalDateTime} 对象 or null
     */
    public static LocalDateTime dateToLocalDateTime(Date date) {
        return Optional.ofNullable(date).map(date1 -> date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()).orElse(null);
    }

    /**
     *  将 {@link Date} 转换为 {@link LocalDate} 对象
     * @param date {@link Date} 对象
     * @return {@link LocalDate} 对象 or null
     */
    public static LocalDate dateToLocalDate(Date date) {
        return Optional.ofNullable(date).map(date1 -> date1.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).orElse(null);
    }
    /**
     *  将 {@link Date} 转换为 {@link LocalTime} 对象
     * @param date {@link Date} 对象
     * @return {@link LocalTime} 对象 or null
     */
    public static LocalTime dateToLocalTime(Date date) {
        return Optional.ofNullable(date).map(date1 -> date1.toInstant().atZone(ZoneId.systemDefault()).toLocalTime()).orElse(null);
    }
}

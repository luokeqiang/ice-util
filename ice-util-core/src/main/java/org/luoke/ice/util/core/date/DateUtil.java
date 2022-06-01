package org.luoke.ice.util.core.date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

/**
 *  时间日期工具类
 * @author luoke
 * @date 2022/5/31 16:48
 */
public class DateUtil {
    private DateUtil(){}

    /**
     *  格式化 {@link LocalDateTime} 对象为{@link String} 对象
     * @param localDateTime {@link LocalDateTime} 对象
     * @param pattern 格式
     * @return {@link String} 对象 or null if param if null
     */
    public static String format(LocalDateTime localDateTime, String pattern) {
        return Optional.ofNullable(localDateTime).map(localDateTime1 -> localDateTime1.format(DateTimeFormatter.ofPattern(pattern))).orElse(null);
    }

    /**
     *  格式化 {@link LocalDateTime} 对象为{@link String} 对象
     * @param localDate {@link LocalDateTime} 对象
     * @param pattern 格式
     * @return {@link String} 对象 or null if param if null
     */
    public static String format(LocalDate localDate, String pattern) {
        return Optional.ofNullable(localDate).map(localDate1 -> localDate1.format(DateTimeFormatter.ofPattern(pattern))).orElse(null);
    }

    /**
     *  格式化 {@link LocalTime} 对象为{@link String} 对象
     * @param localTime {@link LocalTime} 对象
     * @param pattern 格式
     * @return {@link String} 对象 or null if param if null
     */
    public static String format(LocalTime localTime, String pattern) {
        return Optional.ofNullable(localTime).map(localTime1 -> localTime1.format(DateTimeFormatter.ofPattern(pattern))).orElse(null);
    }

    /**
     *  格式化 {@link Date} 对象为{@link String} 对象
     * @param date {@link Date} 对象
     * @param pattern 格式
     * @return {@link String} 对象 or null if param if null
     */
    public static String format(Date date, String pattern) {
        return format(DateConverter.dateToLocalDateTime(date), pattern);
    }

    /**
     *  将文本字符串按照指定格式转化为 {@link LocalDateTime} 对象
     * @param text 时间日期文本字符串
     * @param pattern 文本格式
     * @return {@link LocalDateTime}对象或 null if text is null
     */
    public static LocalDateTime parseLocalDateTime(String text, String pattern) {
        if (text == null) {
            return null;
        }
        return Optional.ofNullable(pattern)
                .map(patternTemp -> LocalDateTime.parse(text,DateTimeFormatter.ofPattern(patternTemp)))
                .orElseGet(() -> LocalDateTime.parse(text));
    }

    /**
     *  将文本字符串按照指定格式转化为 {@link LocalDate} 对象
     * @param text 时间日期文本字符串
     * @param pattern 文本格式
     * @return {@link LocalDate}对象或 null if text is null
     */
    public static LocalDate parseLocalDate(String text, String pattern) {
        if (text == null) {
            return null;
        }
        return Optional.ofNullable(pattern)
                .map(patternTemp -> LocalDate.parse(text,DateTimeFormatter.ofPattern(patternTemp)))
                .orElseGet(() -> LocalDate.parse(text));
    }

    /**
     *  将文本字符串按照指定格式转化为 {@link LocalTime} 对象
     * @param text 时间日期文本字符串
     * @param pattern 文本格式
     * @return {@link LocalTime}对象或 null if text is null
     */
    public static LocalTime parseLocalTime(String text, String pattern) {
        if (text == null) {
            return null;
        }
        return Optional.ofNullable(pattern)
                .map(patternTemp -> LocalTime.parse(text,DateTimeFormatter.ofPattern(patternTemp)))
                .orElseGet(() -> LocalTime.parse(text));
    }

    /**
     *  将文本字符串按照指定格式转化为 {@link Date} 对象
     * @param text 时间日期文本字符串
     * @param pattern 文本格式
     * @return {@link Date}对象或 null if text is null
     */
    public static Date parseDate(String text, String pattern) {
        if (text == null) {
            return null;
        }
        return DateConverter.localDateTimeToDate(parseLocalDateTime(text, pattern));
    }
}

/*
 * Created By: Pranshu Shrivastava

 * All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.spranshu1.common.util.date;

import com.github.spranshu1.common.util.string.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * The Class DateUtils.
 */
public final class DateTimeUtil {

    /**
     * The ISO date format {@value}
     */
    public static final String ISO_DATE_FMT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";  // Quoted "Z" to indicate UTC, no timezone offset
    /**
     * The logger.
     */
    private final static Logger logger = LoggerFactory.getLogger(DateTimeUtil.class);
    /**
     * The constant for Timestamp format object
     */
    private static final DateTimeFormatter TF = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");

    /**
     * The Constant for DateFormat object.
     */
    private static final DateTimeFormatter DF = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /**
     * The Constant for ISO DateFormat object.
     */
    private static final DateTimeFormatter isoDF = DateTimeFormatter.ofPattern(ISO_DATE_FMT);

    static {
        isoDF.withZone(ZoneOffset.UTC);
        DF.withZone(ZoneId.systemDefault());
        TF.withZone(ZoneId.systemDefault());
    }


    /**
     * Checks if firstDate date is equal to or greater than secondDate.
     * Example,
     * <pre><code>
     * 	// Create Dates
     * 	LocalDateTime firstDate = LocalDateTime.of(2020, 2, 24, 11, 55);
     * 	LocalDateTime secondDate = LocalDateTime.of(2020, 2, 23, 11, 55);
     *
     * 	// Check if firstDate is after secondDate
     * 	boolean isAfter = DateTimeUtil.<b>isDateAfter</b>(firstDate, secondDate);
     * </code></pre>
     *
     * @param firstDate  the first date
     * @param secondDate the second date
     * @return true, if is date after
     */
    public static boolean isDateAfter(final LocalDateTime firstDate, final LocalDateTime secondDate) {
        final boolean response;
        response = (firstDate != null && secondDate != null)
                && (firstDate.isAfter(secondDate) || firstDate.isEqual(secondDate));
        return response;
    }


    /**
     * Gets current timestamp in system default locale.
     *
     * @return {@link Instant} current time-stamp
     */
    public static Instant getTimestamp() {
        return new Timestamp(System.currentTimeMillis()).toInstant();
    }

    /**
     * Convert string to {@link LocalDateTime}.
     * Example,
     * <pre><code>
     * 	//Convert String to LocalDateTime
     * 	LocalDateTime result = DateTimeUtil.<b>stringToLocalDateTime</b>("2016-03-04 11:30:40", "yyyy-MM-dd HH:mm:ss");
     * </code></pre>
     *
     * @param dateTime the date time string
     * @param format   the format
     * @return the parsed {@link LocalDateTime}
     */
    public static LocalDateTime stringToLocalDateTime(final String dateTime, final String format) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return (StringUtil.strFieldIsEmpty(dateTime)) ? null : LocalDateTime.parse(dateTime, formatter);
    }


    /**
     * Converts given String field 'dtField' to a {@link LocalDate} object, using given date format 'dtFormat'.
     *
     * @param dtField  String field which is to be converted to Date object
     * @param dtFormat String representing expected date pattern (as per SimpleDateFormat class)
     * @return the parsed {@link LocalDate}
     */
    public static LocalDate stringToLocalDate(final String dtField, final String dtFormat) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dtFormat);
        return (StringUtil.strFieldIsEmpty(dtField)) ? null : LocalDate.parse(dtField, formatter);
    }

    /**
     * Convert date to ISO {@value ISO_DATE_FMT} string format.
     *
     * @param date the date
     * @return the string
     */
    public static String dateToISOString(final LocalDateTime date) {
        return date == null ? null : date.format(isoDF);
    }

    /**
     * Convert date to "yyyy-MM-dd" string format.
     *
     * @param date the date
     * @return the string
     */
    public static String dateToString(final LocalDate date) {
        return date == null ? null : DF.format(date);
    }


    /**
     * Convert date to "yyyy-MM-dd'T'HH:mm:ss.SSS" timestamp string format.
     *
     * @param date the date
     * @return the string
     */
    public static String timestampToString(final LocalDate date) {
        return date == null ? null : TF.format(date);
    }


    /**
     * Convert string to date format.
     *
     * @param isoDateStr the iso date str
     * @return the local date
     */
    public static LocalDate isoStringToDate(final String isoDateStr) {
        return LocalDate.parse(isoDateStr,isoDF);
    }

    /**
     * Returns the minute part of the given input parameter date.
     *
     * @param date {@link Date}
     * @return int minute in the date
     */
    public static int getMinute(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MINUTE);
    }


}

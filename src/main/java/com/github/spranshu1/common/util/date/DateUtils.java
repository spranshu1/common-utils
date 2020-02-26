/**
 * @author pranshu.shrivastava
 * @date Feb 24, 2020
 */
package com.github.spranshu1.common.util.date;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.github.spranshu1.common.util.string.StringUtils;

/**
 * The Class DateUtils.
 */
public class DateUtils {
	
	/**
	 * Checks if firstDate date is equal to or greater than secondDate.
	 * Example,
	 * <pre><code>
	 * 	// Create Dates 
	 * 	LocalDateTime firstDate = LocalDateTime.of(2020, 2, 24, 11, 55);
	 *	LocalDateTime secondDate = LocalDateTime.of(2020, 2, 23, 11, 55);
	 *  
	 * 	// Check if firstDate is after secondDate 
	 * 	boolean isAfter = DateUtil.<b>isDateAfter</b>(firstDate, secondDate);
	 * </code></pre>
	 * @param firstDate  the first date
	 * @param secondDate the second date
	 * @return true, if is date after
	 */
	public static boolean isDateAfter(final LocalDateTime firstDate, final LocalDateTime secondDate) {
		final boolean response;
		if ((firstDate != null && secondDate != null)
				&& (firstDate.isAfter(secondDate) || firstDate.isEqual(secondDate))) {
			response = true;
		} else {
			response = false;
		}
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
	 *	//Convert String to LocalDateTime
	 *	LocalDateTime result = DateUtil.<b>convertStringToDate</b>("10/06/2020", "dd/mm/uuuu");
	 * </code></pre>
	 *
	 * @param dateTime the date time string
	 * @param format the format
	 * @return the parsed {@link LocalDateTime} time
	 */
	public static LocalDateTime convertStringToDate(final String dateTime, final String format) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return (StringUtils.strFieldIsEmpty(dateTime)) ? null : LocalDateTime.parse(dateTime, formatter);
	}



}

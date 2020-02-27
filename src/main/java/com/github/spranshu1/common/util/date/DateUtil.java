/**
 * @author pranshu.shrivastava
 * @date Feb 24, 2020
 */
package com.github.spranshu1.common.util.date;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.spranshu1.common.util.string.StringUtil;

/**
 * The Class DateUtils.
 */
public class DateUtil {
	
	/** The logger. */
	private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);
	
	/** The ISO date format {@value}*/
	public static final String	ISO_DATE_FMT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";  // Quoted "Z" to indicate UTC, no timezone offset

	
	/** The Constant for DateFormat object. */
	private static final DateFormat DF = new SimpleDateFormat(ISO_DATE_FMT);
	static {
		DF.setTimeZone(TimeZone.getTimeZone("UTC"));
	}
	
	
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
	 *	LocalDateTime result = DateUtil.<b>stringToLocalDateTime</b>("10/06/2020", "dd/mm/uuuu");
	 * </code></pre>
	 *
	 * @param dateTime the date time string
	 * @param format the format
	 * @return the parsed {@link LocalDateTime} time
	 */
	public static LocalDateTime stringToLocalDateTime(final String dateTime, final String format) {
		final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
		return (StringUtil.strFieldIsEmpty(dateTime)) ? null : LocalDateTime.parse(dateTime, formatter);
	}


	/**
	 * Converts given String field 'dtField' to a Date object, using given date format 'dtFormat'.
	 *
	 * @param dtField        String field which is to be converted to Date object
	 * @param dtFormat        String representing expected date pattern (as per SimpleDateFormat class)
	 * @return Date - if given String can be converted to Date object without exception,
	 *         null - otherwise.
	 */
	public static Date stringToDate(final String dtField, final String dtFormat) {
		Date retDate = null;
		final SimpleDateFormat fmt = new SimpleDateFormat(dtFormat);
		fmt.setLenient(false);
		try {
			retDate = fmt.parse(dtField);
		}catch(ParseException e){
			logger.info("[{}] not in expected format {}", dtField, dtFormat);
			return null;
		}
		return retDate;
	}

	/**
	 * Convert date to ISO string format.
	 *
	 * @param date the date
	 * @return the string
	 */
	public static String dateToISOString(final Date date) {
		return date==null ? null : DF.format(date);
	}

	/**
	 * Convert string to date format.
	 *
	 * @param isoDateStr the iso date str
	 * @return the date
	 */
	public static Date isoStringToDate(final String isoDateStr) {
		try {
			return DF.parse(isoDateStr);
		}
		catch (ParseException e) {
			return null;
		}
	}
	

}

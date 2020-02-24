/**
 * These materials are confidential and proprietary to Intellect Design Arena Ltd. and no part of these
 * materials should be reproduced, published, transmitted or distributed in any form or by any means,
 * electronic, mechanical, photocopying, recording or otherwise, or stored in any information storage or
 * retrieval system of any nature nor should the materials be disclosed to third parties or used in any
 * other manner for which this is not authorized, without the prior express written authorization of
 * Intellect Design Arena Ltd.
 *
 * Copyright 2017 Intellect Design Arena Limited. All rights reserved.
 *
 * @author pranshu.shrivastava
 * @date Feb 24, 2020
 */
package com.common.util.date;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.common.util.string.StringUtil;

public class DateUtil {
	
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
		return (StringUtil.strFieldIsEmpty(dateTime)) ? null : LocalDateTime.parse(dateTime, formatter);
	}



}

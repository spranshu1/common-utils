package com.github.spranshu1.common.util.test.date;

import com.github.spranshu1.common.util.date.DateTimeUtil;
import org.junit.Assert;
import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The type Date time util test.
 */
public class DateTimeUtilTest {

    /**
     * Test is date after.
     */
    @Test
    public void testIsDateAfter(){
        LocalDateTime first = LocalDateTime.now();
        LocalDateTime second = LocalDateTime.of(2012,6,10,00,15);

        boolean isAfter = DateTimeUtil.isDateAfter(first,second);
        Assert.assertTrue(isAfter);
    }

    /**
     * Test timestamp.
     */
    @Test
    public void testTimestamp(){
        Instant instant = DateTimeUtil.getTimestamp();
        Assert.assertNotNull(instant);
    }

    /**
     * Test str to local date time.
     */
    @Test
    public void testStrToLocalDateTime(){
        String expected = "2016-03-04T11:30:40";
        LocalDateTime result = DateTimeUtil.stringToLocalDateTime("2016-03-04 11:30:40", "yyyy-MM-dd HH:mm:ss");
        Assert.assertEquals(expected,result.toString());
    }

    /**
     * Test str to date.
     */
    @Test
    public void testStrToDate(){
        String expected = "2016-03-04";
        LocalDate date = DateTimeUtil.stringToLocalDate("2016-03-04","yyyy-MM-dd");
        Assert.assertEquals(expected,date.toString());
    }

    /**
     * Test date to iso string.
     */
    @Test
    public void testDateToISOString(){
        LocalDateTime date = LocalDateTime.of(2012, 06, 10,00,00,00);
        String strDate = DateTimeUtil.dateToISOString(date);
        Assert.assertEquals("2012-06-10T00:00:00.000Z",strDate);
    }

    /**
     * Test date to string.
     */
    @Test
    public void testDateToString(){
        String date = DateTimeUtil.dateToString(LocalDate.of(2012,06,10));
        Assert.assertEquals("2012-06-10",date.toString());
    }
}

package com.limitlessaudio.furfriction.podcast.util;

import java.util.Calendar;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

/**Java class for testing {@link DateConverter} class.
 */
public class DateConverterTest {

    @Before
    public void setUp() {

    }

    @Test
    public void testConvertDateToRFC2822ShouldReturnFormattedStringWhenDefaultTimeZoneGiven() {
        // GIVEN
        String expected = "Sun, 02 Nov 2014 12:45:00 +0100";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 10, 02, 12, 45, 00);
        // WHEN
        String actual = DateConverter.convertDateToRFC2822(calendar.getTime());
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testConvertDateToRFC2822ShouldReturnEmptyStringWhenNullIsGiven() {
        // GIVEN
        String expected = "";
        // WHEN
        String actual = DateConverter.convertDateToRFC2822(null);
        // THEN
        Assert.assertEquals(expected, actual);
    }
}

/**
 * 
 */
package com.limitlessaudio.furfriction.podcast.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

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
    public void testConvertDateToRFC822ShouldReturn() {
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
    public void testConvertDateToRFC822ShouldReturnA() {
        // GIVEN
        String expected = "Sun, 02 Nov 2014 12:45:00 +0100";
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT +1"));
        Calendar calendar = dateFormat.getCalendar();
        calendar.set(2014, 10, 02, 11, 45, 00);
        // WHEN
        String actual = DateConverter.convertDateToRFC2822(calendar.getTime());
        // THEN
        Assert.assertEquals(expected, actual);
    }

}

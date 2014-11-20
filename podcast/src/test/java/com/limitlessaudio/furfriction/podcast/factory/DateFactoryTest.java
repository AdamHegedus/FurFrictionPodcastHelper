package com.limitlessaudio.furfriction.podcast.factory;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**Test class for {@link DateFactory} class.
 * @author x
 */
public class DateFactoryTest {
    private DateFactory underTest;

    @Before
    public void setUp() {
        underTest = new DateFactory();
    }

    @Test
    public void testGetMonthsLastDayAsDayOfWeekShouldReturnLastSunday() {
        // GIVEN
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 11, 28, 20, 0, 0);
        Date expected = calendar.getTime();
        // WHEN
        Date actual = underTest.getMonthsLastDayAsDayOfWeek(11, 2014, Calendar.SUNDAY);
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonthsLastDayAsDayOfWeekShouldReturnLastMonday() {
        // GIVEN
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 11, 29, 20, 0, 0);
        Date expected = calendar.getTime();
        // WHEN
        Date actual = underTest.getMonthsLastDayAsDayOfWeek(11, 2014, Calendar.MONDAY);
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonthsLastDayAsDayOfWeekShouldReturnLastTuesday() {
        // GIVEN
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 11, 30, 20, 0, 0);
        Date expected = calendar.getTime();
        // WHEN
        Date actual = underTest.getMonthsLastDayAsDayOfWeek(11, 2014, Calendar.TUESDAY);
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonthsLastDayAsDayOfWeekShouldReturnLastWednesday() {
        // GIVEN
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 11, 31, 20, 0, 0);
        Date expected = calendar.getTime();
        // WHEN
        Date actual = underTest.getMonthsLastDayAsDayOfWeek(11, 2014, Calendar.WEDNESDAY);
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonthsLastDayAsDayOfWeekShouldReturnLastThursday() {
        // GIVEN
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 11, 25, 20, 0, 0);
        Date expected = calendar.getTime();
        // WHEN
        Date actual = underTest.getMonthsLastDayAsDayOfWeek(11, 2014, Calendar.THURSDAY);
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonthsLastDayAsDayOfWeekShouldReturnLastFriday() throws InterruptedException {
        // GIVEN
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 11, 26, 20, 0, 0);
        Date expected = calendar.getTime();
        // WHEN
        Date actual = underTest.getMonthsLastDayAsDayOfWeek(11, 2014, Calendar.FRIDAY);
        // THEN
        Assert.assertEquals(expected.getTime(), actual.getTime());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetMonthsLastDayAsDayOfWeekShouldReturnLastSaturday() {
        // GIVEN
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 11, 27, 20, 0, 0);
        Date expected = calendar.getTime();
        // WHEN
        Date actual = underTest.getMonthsLastDayAsDayOfWeek(11, 2014, Calendar.SATURDAY);
        // THEN
        Assert.assertEquals(expected, actual);
    }

}

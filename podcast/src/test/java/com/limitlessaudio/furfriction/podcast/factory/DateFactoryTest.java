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
    public void testGetLastSundayShouldReturn2014November30When2014NovemberGiven() {
        // GIVEN
        Calendar calendar = Calendar.getInstance();
        calendar.set(2014, 10, 30, 20, 0, 0);
        Date expected = calendar.getTime();
        // WHEN
        Date actual = underTest.getLastSunday(10, 2014);
        // THEN
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetLastSundayShouldReturn2015January25When2015JanuaryGiven() {
        // GIVEN
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 0, 25, 20, 0, 0);
        Date expected = calendar.getTime();
        // WHEN
        Date actual = underTest.getLastSunday(0, 2015);
        // THEN
        Assert.assertEquals(expected, actual);
    }
}

package com.limitlessaudio.furfriction.podcast.factory;

import java.util.Calendar;
import java.util.Date;

/**Generates {@link Date} objects by given parameters.
 * @author adam_hegedus
 */
public class DateFactory {

    private static final int RELEASE_SECOND = 0;
    private static final int RELEASE_MINUTE = 0;
    private static final int RELEASE_HOUR = 20;
    private static final int DAYS_IN_WEEK = 7;

    public Date getLastSunday(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month + 1, 1, RELEASE_HOUR, RELEASE_MINUTE, RELEASE_SECOND);
        int dayOfMonth = -(calendar.get(Calendar.DAY_OF_WEEK) % DAYS_IN_WEEK - 1);
        calendar.add(Calendar.DAY_OF_MONTH, dayOfMonth);
        return calendar.getTime();
    }
}

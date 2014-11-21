package com.limitlessaudio.furfriction.podcast.factory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**Generates {@link Date} objects by given parameters.
 * @author adam_hegedus
 */
public class DateFactory {

    private static final int RELEASE_SECOND = 0;
    private static final int RELEASE_MINUTE = 0;
    private static final int RELEASE_HOUR = 20;
    private static final int DAYS_IN_WEEK = 7;

    /**Gets the last "Day Of Week" of the specified year and month.
     * @param month the number of the month, numbered from zero
     * @param year the number of the year
     * @param dayOfWeek the {@link Calendar} DAY_OF_WEEK data which we need the last of
     * @return the last day of week in the month
     */
    public Date getMonthsLastDayAsDayOfWeek(final int month, final int year, final int dayOfWeek) {
        final Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month + 1, 1, RELEASE_HOUR, RELEASE_MINUTE, RELEASE_SECOND);

        int dayOffset = getLastDayOffset(calendar, dayOfWeek);
        if (dayOffset >= 0) {
            dayOffset += -DAYS_IN_WEEK;
        }

        calendar.add(Calendar.DAY_OF_MONTH, dayOffset);
        return calendar.getTime();
    }

    private int getLastDayOffset(final Calendar calendar, final int dayOfWeek) {
        return -(calendar.get(Calendar.DAY_OF_WEEK) % DAYS_IN_WEEK - dayOfWeek);
    }

    /**
     * Converts input {@link java.util.Date } object to RFC-2822 style
     * {@link String } object in US locale.
     * @param date is {@link java.util.Date } object which the method should
     *            convert from.
     * @return date in RFC822 formatted {@link String }
     */
    public String convertDateToRFC2822(final Date date) {
        String convertedDate;
        if (date == null) {
            convertedDate = "";
        } else {
            convertedDate = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US).format(date);
        }
        return convertedDate;
    }
}

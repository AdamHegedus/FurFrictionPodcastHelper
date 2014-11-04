package com.limitlessaudio.furfriction.podcast.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * Helper Class for handling {@link java.util.Date} objects.
 */
public final class DateConverter {

    private DateConverter() {

    }

    /**
     * Converts input {@link java.util.Date } object to RFC-2822 style
     * {@link String } object in US locale.
     * @param date is {@link java.util.Date } object which the method should
     *            convert from.
     * @return date in RFC822 formatted {@link String }
     */
    public static String convertDateToRFC2822(java.util.Date date) {
        String result = "";
        result = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US).format(date);
        return result;
    }
}

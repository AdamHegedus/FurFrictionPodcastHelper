/**
 * 
 */
package com.limitlessaudio.furfriction.podcast.util;

import java.text.SimpleDateFormat;
import java.util.Locale;

/**
 * @author x
 */
public class DateConverter {

    /**
     * Converts input {@link java.util.Date } object to RFC-822 style
     * {@link String } object in US locale.
     * @param date is {@link java.util.Date } object which the method should
     *            convert from.
     * @return date in RFC822 formatted {@link String }
     */
    public static String convertDateToRFC822(java.util.Date date) {
        String result = "";
        result = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.US)
                .format(date);
        return result;
    }
}

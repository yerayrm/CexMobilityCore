package com.cexmobility.core.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DateUtils {

    public static final String FORMAT_DATE_ZULU = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String FORMAT_DATE_DATE_AND_TIME = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String FORMAT_DATE_WITH_SCORE = "dd-MM-yyyy";
    public static final String FORMAT_DATE_WITH_BARS = "dd/MM/yyyy";
    public static final String FORMAT_HOUR = "HH:mm";


    public static String formatDate(String dateStr, String inputFormat, String outputFormat) throws ParseException {
        TimeZone utc = TimeZone.getTimeZone("UTC");
        SimpleDateFormat sourceFormat = new SimpleDateFormat(inputFormat, Locale.ENGLISH);
        SimpleDateFormat destFormat = new SimpleDateFormat(outputFormat, Locale.ENGLISH);
        sourceFormat.setTimeZone(utc);
        Date convertedDate = sourceFormat.parse(dateStr);
        return destFormat.format(convertedDate);
    }

}

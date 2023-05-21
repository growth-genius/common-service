package com.sgyj.commonservice.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import lombok.Getter;
import org.springframework.util.StringUtils;

@Getter
public final class TimeUtil {

    public static final String PATTERN = "yyyy-MM-dd'T'HH:mm:ss";
    private final LocalTime basicStartTime;

    private final LocalTime basicEndTime;

    private TimeUtil () {
        throw new AssertionError();
    }

    public static TimeUtil of () {
        return new TimeUtil();
    }

    public static LocalDate formatDateTime ( String date ) {
        return LocalDate.parse( splitDate( date ), DateTimeFormatter.ofPattern( PATTERN ) );
    }

    public static LocalDateTime formatLocalDateTime ( String date ) {
        if ( !StringUtils.hasText( date ) ) {
            return null;
        }
        return LocalDateTime.parse( splitDate( date ), DateTimeFormatter.ofPattern( PATTERN ) );
    }

    public static String splitDate ( String creationDate ) {
        if ( creationDate.contains( "." ) ) {
            creationDate = creationDate.split( "\\." )[0];
        } else if ( creationDate.lastIndexOf( "Z" ) != -1 ) {
            creationDate = creationDate.substring( 0, creationDate.length() - 1 );
        }
        return creationDate;
    }

    public static String formatLocalDateTimeToString ( LocalDateTime localDateTime ) {
        return localDateTime.format( DateTimeFormatter.ofPattern( "yyyyMMdd" ) );
    }

    public static String getTodayYmd () {
        return LocalDate.now().format( DateTimeFormatter.ofPattern( "yyyyMMdd" ) );
    }

    public static String getTodayYm () {
        return LocalDate.now().format( DateTimeFormatter.ofPattern( "yyyyMM" ) );
    }

    public static String getThisYear () {
        return LocalDate.now().format( DateTimeFormatter.ofPattern( "yyyy" ) );
    }

    public static LocalDateTime convertStringToLocalDateTime ( String datetime, String pattern ) {
        return LocalDateTime.parse( datetime, DateTimeFormatter.ofPattern( pattern ) );
    }

    public static String convertFullDateToYmd ( String creationDate ) {
        String s = splitDate( creationDate );
        int idx = s.indexOf( "T" );
        return s.substring( 0, idx ).replace( "-", "" );
    }


}

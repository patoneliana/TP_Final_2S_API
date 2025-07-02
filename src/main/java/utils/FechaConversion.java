package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FechaConversion {
    public static String format(String fechaOriginal) throws ParseException {

        // 1. Parsear con SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
        sdf.setTimeZone(TimeZone.getTimeZone("America/Argentina/Buenos_Aires"));
        Date date = sdf.parse(fechaOriginal);

        // 2. Convertir a Instant
        Instant instant = date.toInstant();

        // 3. Convertir a UTC (ZonedDateTime en UTC)
        ZonedDateTime utcDateTime = instant.atZone(ZoneOffset.UTC);

        // 4. Formatear al formato ISO 8601
        String isoUtc = utcDateTime.format(DateTimeFormatter.ISO_INSTANT);
        return isoUtc;
    }
}

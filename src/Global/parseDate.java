package Global;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class parseDate {

    public static LocalDateTime parseDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateTimeString, formatter);
    }

}

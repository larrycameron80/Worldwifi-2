package Comun;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String currentFormattedDate() {
        return (new SimpleDateFormat("yyyy-MMM-dd'T'HH:mm:ssZ")).format(new Date());
    }

    public static String dateFormatter(Date date) {
        return (new SimpleDateFormat("dd MMM yy")).format(date);
    }

    public static void main(String[] args) {
        System.out.println(currentFormattedDate());
    }
}
package dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateExample {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2082, Calendar.JANUARY, 31);
        Date date = calendar.getTime();
        System.out.println(date);


        SimpleDateFormat hoursAndMins = new SimpleDateFormat("hh:mm", Locale.US);
        String hoursAndMinsFormatted = hoursAndMins.format(date);
        System.out.println(hoursAndMinsFormatted);

    }


}

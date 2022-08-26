package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DateExample {

    public static void main(String[] args) throws ParseException {

        Calendar calendar = Calendar.getInstance();
        calendar.set(2082, Calendar.JANUARY, 31);
        Date date = calendar.getTime();
        System.out.println(date);


        SimpleDateFormat hoursAndMins = new SimpleDateFormat("hh:mm", Locale.US);
        String hoursAndMinsFormatted = hoursAndMins.format(date);
        System.out.println(hoursAndMinsFormatted);

        String dateAsString = "01/08/2022";
        Date olDate = new SimpleDateFormat("MM/dd/yyyy").parse(dateAsString);

        System.out.println("New Date " + addDaysToDate(olDate, 4));

    }

    private static Date addDaysToDate(Date oldDate, int daysToAdd) {
        Calendar c = Calendar.getInstance();
        c.setTime(oldDate);
        c.add(Calendar.DAY_OF_MONTH, daysToAdd);
        return c.getTime();
    }


}

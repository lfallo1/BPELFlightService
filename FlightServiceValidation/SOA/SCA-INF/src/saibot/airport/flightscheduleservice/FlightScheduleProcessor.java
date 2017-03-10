package saibot.airport.flightscheduleservice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FlightScheduleProcessor {
    public FlightScheduleProcessor() {
    }

    public static int calculateNumberOfFlights(String startDateString, String endDateString, int numDaysPerWeek) {
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

            if (endDateString == null || endDateString.length() == 0) {
                    return 1;
            }

            try {
                    Date startDate = formatter.parse(startDateString);
                    Date endDate = formatter.parse(endDateString);
                    long dayDiff = getDateDiff(startDate, endDate, TimeUnit.DAYS);
                    return (int) dayDiff * numDaysPerWeek / 7;
            } catch (ParseException e) {
                    e.printStackTrace();
                    return 0;
            }
    }

    private static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
            return timeUnit.convert(date2.getTime() - date1.getTime(), TimeUnit.MILLISECONDS);
    }
}

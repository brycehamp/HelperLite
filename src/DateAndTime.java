import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DateAndTime {
    private LocalTime time = LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
    private LocalDate date = LocalDate.now();
    private String giveTime = "The current time is " + time.toString() + ".";
    private String giveDate = "The current date is " + date.toString() + ".";
    private String dateAndTime = "The date is " + date.toString() + " and the time is " + time.toString() + ".";
    private String determiner = "Sorry, please try again, being sure to follow the instructions.";

    //determines which String to return based on user input
    public String determineDateTime(String s) {
        if(s.toLowerCase().contains("time") && s.toLowerCase().contains("date")) {
            return dateAndTime;
        }
        if (s.toLowerCase().contains("time")) {
            return giveTime;
        }
        if (s.toLowerCase().contains("date")) {
            return giveDate;
        }
        
        return determiner;
    }

}

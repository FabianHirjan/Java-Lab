import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
public class Church extends Attraction implements Visitable, Payable {
    private Map<LocalDate, TimeInterval> timetable = new HashMap<>();
    private double ticketPrice;
    private String name;


    @Override
    public Map<LocalDate,TimeInterval> getTimetable() {
        return timetable;
    }
    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }
    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public Church(String name, Map<LocalDate, TimeInterval> timetable, double ticketPrice) {
        super(name);
        this.timetable = timetable;
        this.ticketPrice = ticketPrice;
    }
}
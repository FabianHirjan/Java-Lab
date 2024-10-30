
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Concert extends Attraction implements Visitable, Payable {
    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;

    public Concert(String name) {
        super(name);
        this.timetable = new HashMap<>();
    }

    @Override
    public String getOpeningHours() {
        return null;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    public void setTimetable(Map<LocalDate, TimeInterval> timetable) {
        this.timetable = timetable;
    }

    public void addTimeSlot(LocalDate date, LocalTime startTime, LocalTime endTime) {
        timetable.put(date, new TimeInterval(startTime, endTime));
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
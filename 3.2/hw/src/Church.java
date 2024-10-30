
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Church extends Attraction implements Visitable {
    private Map<LocalDate, TimeInterval> timetable;

    public Church(String name) {
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
}
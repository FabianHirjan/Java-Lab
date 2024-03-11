//In Visitable.java
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Map;
public interface Visitable {
    public Map<LocalDate,TimeInterval> getTimetable();
    default LocalTime getOpeningHour(LocalDate date) {
        TimeInterval timeInterval = getTimetable().get(date);
        if (timeInterval != null) {
            return timeInterval.getFirst();
        } else {
            return null;
        }
    }
}
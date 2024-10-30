import java.time.LocalDate;
import java.time.LocalTime;
class TimeInterval extends Pair<LocalTime, LocalTime> {
    public TimeInterval(LocalTime first, LocalTime second) {
        super(first, second);
    }
}
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        LocalDate concertDate = LocalDate.of(2024, 3, 20);

        LocalTime startTime = LocalTime.of(18, 0); // 6 PM
        LocalTime endTime = LocalTime.of(20, 0); // 8 PM

        TimeInterval concertTimeInterval = new TimeInterval(startTime, endTime);

        // Creating a Map to serve as the timetable
        Map<LocalDate, TimeInterval> concertTimetable = new HashMap<>();
        concertTimetable.put(concertDate, concertTimeInterval);

        Concert concert = new Concert("TZU",concertTimetable, 300);
        Museum museum = new Museum("TZU",concertTimetable, 300);
        System.out.println(museum.getOpeningHour(concertDate));

        System.out.println(museum.getTicketPrice());

        Attraction[] arr = {museum, concert};

        int nbObjects = 1_000_000;


    }

}
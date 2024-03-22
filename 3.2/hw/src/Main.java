import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Concert concert = new Concert("Concert random");
        concert.addTimeSlot(LocalDate.of(2024, 7, 12), LocalTime.of(22, 0), LocalTime.of(23, 0));
        concert.setTicketPrice(300);

        Concert concert2 = new Concert("Concert random2");
        concert2.addTimeSlot(LocalDate.of(2025, 7, 12), LocalTime.of(22, 0), LocalTime.of(23, 0));

        Match match = new Match("bataia suprema", Match.MatchType.FOOTBALL, "Steaua", "Poli Iasi");
        match.addTimeSlot(LocalDate.of(2024, 7, 13), LocalTime.of(20, 30), LocalTime.of(22, 45));
        match.setTicketPrice(15);

        Church church = new Church("Biserica Sf Sava");
        Map<LocalDate, TimeInterval> churchTimetable = new HashMap<>();
        churchTimetable.put(LocalDate.of(2024, 7, 13), new TimeInterval(LocalTime.of(9, 0), LocalTime.of(11, 0)));
        church.setTimetable(churchTimetable);

        Statue statue = new Statue("Hydra", "Dusmanul batranilor");
        Map<LocalDate, TimeInterval> statueTimetable = new HashMap<>();

        Trip trip = new Trip("Iasi", "2024-07-10", "2024-07-15");
        trip.addAttraction(concert);
        trip.addAttraction(church);
        trip.addAttraction(statue);
        trip.addAttraction(match);
        trip.addAttraction(concert2);

        System.out.println(trip);
        System.out.println("Attractions:");
        for (Attraction attraction : trip.getAttractions()) {
            System.out.println(attraction.getName());
            if (attraction instanceof Visitable) {
                Map<LocalDate, TimeInterval> timetable = ((Visitable) attraction).getTimetable();
                if (timetable != null) {

                    for (Map.Entry<LocalDate, TimeInterval> entry : timetable.entrySet()) {
                            System.out.println("Date: " + entry.getKey() + ", From " + entry.getValue().getFirst() + " - " + entry.getValue().getSecond());
                    }
                } else {
                    System.out.println("No specific opening hours available.");
                }
            }
            if (attraction instanceof Payable) {
                System.out.println("Ticket Price: " + ((Payable) attraction).getTicketPrice() + " lei");
            }
            System.out.println();
        }
    }
}


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class Match extends Attraction implements Visitable, Payable {

    public enum MatchType {
        FOOTBALL,
        BASEBALL,
        SOCCER,
        BASKETBALL,

    }
    private MatchType matchType;
    private String team1;
    private String team2;
    private Map<LocalDate, TimeInterval> timetable;
    private double ticketPrice;

    public Match(String name) {
        super(name);
        this.timetable = new HashMap<>();
    }
    public Match(String name, MatchType matchType, String team1, String team2) {
        super(name);
        this.matchType = matchType;
        this.team1 = team1;
        this.team2 = team2;
        this.timetable = new HashMap<>();
    }

    public void addTimeSlot(LocalDate date, LocalTime startTime, LocalTime endTime) {
        timetable.put(date, new TimeInterval(startTime, endTime));
    }

    @Override
    public String getOpeningHours() {
        return null;
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return timetable;
    }

    @Override
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public MatchType getMatchType() {
        return matchType;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }
}

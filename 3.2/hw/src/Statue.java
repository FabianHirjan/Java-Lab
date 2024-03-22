
import java.time.LocalDate;
import java.util.Map;

class Statue extends Attraction implements Visitable {
    private final String description;

    public Statue(String name, String description) {
        super(name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String getOpeningHours() {
        return "Open all day";
    }

    @Override
    public Map<LocalDate, TimeInterval> getTimetable() {
        return null;
    }
}
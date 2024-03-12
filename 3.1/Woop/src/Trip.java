import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Trip {
    private final String cityName;

    private final LocalDate startTime;

    private final LocalDate endTime;

    private final List<Attraction> attractions;

    public Trip(String cityName, String startTime, String endTime) {
        this.cityName = cityName;
        this.startTime = LocalDate.parse(startTime);
        this.endTime = LocalDate.parse(endTime);
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(Attraction attraction) {
        attractions.add(attraction);
    }

    public List<Attraction> getAttractions() {
        return attractions;
    }

    public LocalDate getStart(){
        return startTime;
    }

    public LocalDate getEnd(){
        return endTime;
    }

    public String getCity() {
        return cityName;
    }
// instanceof
    public List<Attraction> isFree() {
        List<Attraction> hopa = new ArrayList<>();
        for (Attraction a : attractions) {
            if (Visitable.class.isAssignableFrom(a.getClass()) && !(Payable.class.isAssignableFrom(a.getClass()))){
                hopa.add(a);
            }
        }
        return hopa;
    }


    @Override
    public String toString() {
        return "Trip to " + cityName + " from " + startTime + " to " + endTime;
    }

}
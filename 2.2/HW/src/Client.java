import java.time.LocalTime;


public class Client {
    private String name;
    private int id;

    public enum ClientType {
        REGULAR,
        PREMIUM;
    }

    private ClientType type;

    private LocalTime minTime;
    private LocalTime maxTime;
    public Client(String name, LocalTime minTime, LocalTime maxTime, ClientType type, int id){
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.type = type;
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getMinTime() {
        return minTime;
    }

    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }

    public LocalTime getMaxTime() {
        return maxTime;
    }

    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }

    public ClientType getType() {
        return type;
    }

    public void setType(ClientType type) {
        this.type = type;
    }

    @Override
    public String toString(){
        return name;
    }

}

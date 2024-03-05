public class Client {
    private int startTime;
    private int stopTime;
    private String Name;
    enum ClientType{
        Premium,
        Normal;
    }
    private ClientType type;

    public Client(int startTime, int stopTime, String name, ClientType type) {
        this.startTime = startTime;
        this.stopTime = stopTime;
        Name = name;
        this.type = type;
    }


    public int getStartTime() {
        return startTime;
    }

    public int getStopTime() {
        return stopTime;
    }

    public String getName() {
        return Name;
    }

    public ClientType getType() {
        return type;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setStopTime(int stopTime) {
        this.stopTime = stopTime;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setType(ClientType type) {
        this.type = type;
    }
}

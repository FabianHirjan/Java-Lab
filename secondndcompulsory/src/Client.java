public class Client {
    private int visitInterval;
    private String Name;
    enum type{
        Premium,
        Normal;
    }
    public Client(int visitInterval, String name) {
        this.visitInterval = visitInterval;
        Name = name;
    }

    public int getVisitInterval() {
        return visitInterval;
    }

    public String getName() {
        return Name;
    }
}

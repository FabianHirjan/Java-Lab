public class Vehicle {
    private String name;
    private Depot depot;

    public Vehicle(String name, Depot depot) {
        this.name = name;
        this.depot = depot;
    }

    @Override
    public String toString(){
        return "Vehicle " + name + " is in depot " + depot.getName();
    }
}

abstract class Vehicle {
    private Depot ownerDepot;
    private String Name;
    private int Location;

    public Vehicle(Depot ownerDepot, String name, int location) {
        this.ownerDepot = ownerDepot;
        this.Name = name;
        this.Location = location;
    }

    public Depot getOwnerDepot() {
        return ownerDepot;
    }

    public String getName() {
        return Name;
    }

    public int getLocation() {
        return Location;
    }

    @Override
    public abstract String toString();
}

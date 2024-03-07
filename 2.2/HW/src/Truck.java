public class Truck extends Vehicle{
    private int Capacity;

    public Truck(Depot ownerDepot, String name, int location, int capacity) {
        super(ownerDepot, name, location);
        this.Capacity = capacity;
    }

    public int getCapacity() {
        return Capacity;
    }

    @Override
    public String toString(){
        return "This truck is owned by " + getOwnerDepot() + " is in " + getLocation() + " and has " + getCapacity() + " capacity, it's name is - " + getName();
    }
}

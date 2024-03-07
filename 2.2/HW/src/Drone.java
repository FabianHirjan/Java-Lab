public class Drone extends Vehicle{
    private int maxFly;

    public Drone(Depot ownerDepot, String name, int location, int maxFly) {
        super(ownerDepot, name, location);
        this.maxFly = maxFly;
    }

    @Override
    public String toString(){
        return "This truck " + " is owned by " + getOwnerDepot() + " is in " + getLocation() + " and has " + " capacity, it's name is - " + getName();
    }
}

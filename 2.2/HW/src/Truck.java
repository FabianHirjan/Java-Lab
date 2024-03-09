/**
 * Reprezintă un camion ca vehicul într-un sistem de logistică.
 * Camionul este caracterizat de capacitatea sa de încărcare.
 */
public class Truck extends Vehicle{
    /**
     * Capacitatea de încărcare a camionului.
     */
    private int Capacity;

    /**
     * Construiește o instanță a unui camion.
     *
     * @param ownerDepot Depozitul care deține acest camion.
     * @param name Numele camionului.
     * @param location Localizarea inițială a camionului.
     * @param capacity Capacitatea de încărcare a camionului.
     */
    public Truck(Depot ownerDepot, String name, int location, int capacity) {
        super(ownerDepot, name, location);
        this.Capacity = capacity;
    }

    /**
     * Returnează capacitatea de încărcare a camionului.
     *
     * @return Capacitatea de încărcare.
     */
    public int getCapacity() {
        return Capacity;
    }

    /**
     * Generează o reprezentare sub formă de șir de caractere a camionului.
     * Include depozitul proprietar, localizarea, capacitatea de încărcare și numele camionului.
     *
     * @return O reprezentare sub formă de șir de caractere a camionului.
     */
    @Override
    public String toString(){
        return "This truck is owned by " + getOwnerDepot() + " is in " + getLocation() + " and has " + getCapacity() + " capacity, it's name is - " + getName();
    }
}

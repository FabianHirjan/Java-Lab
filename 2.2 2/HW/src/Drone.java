/**
 * Clasa {@code Drone} extinde clasa {@code Vehicle} pentru a reprezenta o dronă, cu funcționalități specifice.
 * Această clasă oferă capacitatea de a gestiona și reprezenta informații despre o dronă,
 * inclusiv capacitatea maximă de zbor.
 */
public class Drone extends Vehicle{
    /**
     * Capacitatea maximă de zbor a dronei.
     */
    private int maxFly;

    /**
     * Constructorul clasei {@code Drone}.
     * Inițializează o nouă instanță a clasei {@code Drone} cu detaliile specificate.
     *
     * @param ownerDepot Depozitul proprietar al dronei.
     * @param name Numele dronei.
     * @param location Localizarea curentă a dronei.
     * @param maxFly Capacitatea maximă de zbor a dronei.
     */
    public Drone(Depot ownerDepot, String name, int location, int maxFly) {
        super(ownerDepot, name, location);
        this.maxFly = maxFly;
    }
    /**
     * Returnează o reprezentare sub formă de șir de caractere a dronei.
     *
     * @return Reprezentarea sub formă de șir de caractere a dronei.
     */
    @Override
    public String toString(){
        return "This truck " + " is owned by " + getOwnerDepot() + " is in " + getLocation() + " and has " + " capacity, it's name is - " + getName();
    }
}

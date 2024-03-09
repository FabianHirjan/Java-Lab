/**
 * Reprezintă o clasă abstractă pentru vehicule. Aceasta clasă servește ca bază pentru diferite tipuri de vehicule
 * care pot fi asignate depozitelor. Fiecare vehicul este caracterizat printr-un nume, o locație și coordonatele sale
 * în cadrul depozitului căruia îi aparține.
 */

abstract class Vehicle {
    /**
     * Depozitul căruia îi aparține vehiculul.
     */
    private Depot ownerDepot;
    /**
     * Numele vehiculului.
     */
    private String Name;
    /**
     * Locația vehiculului în cadrul depozitului.
     */
    private int Location;
    /**
     * Coordonata X a vehiculului, derivată din coordonatele depozitului căruia îi aparține.
     */
    private int x;
    /**
     * Coordonata Y a vehiculului, derivată din coordonatele depozitului căruia îi aparține.
     */
    private int y;

    /**
     * Constructor pentru crearea unui vehicul. Setează depozitul proprietar, numele, locația și
     * coordonatele vehiculului bazate pe depozitul căruia îi aparține.
     *
     * @param ownerDepot Depozitul căruia îi aparține vehiculul.
     * @param name       Numele vehiculului.
     * @param location   Locația vehiculului în cadrul depozitului.
     */
    public Vehicle(Depot ownerDepot, String name, int location) {
        this.ownerDepot = ownerDepot;
        this.Name = name;
        this.Location = location;
        this.x = ownerDepot.getX();
        this.y = ownerDepot.getY();
    }

    /**
     * Returnează depozitul căruia îi aparține vehiculul.
     *
     * @return Depozitul proprietar al vehiculului.
     */
    public Depot getOwnerDepot() {
        return ownerDepot;
    }

    /**
     * Returnează numele vehiculului.
     *
     * @return Numele vehiculului.
     */
    public String getName() {
        return Name;
    }

    /**
     * Returnează locația vehiculului în cadrul depozitului.
     *
     * @return Locația vehiculului.
     */
    public int getLocation() {
        return Location;
    }

    /**
     * O metodă abstractă care va fi implementată de subclase pentru a returna o reprezentare
     * textuală a vehiculului.
     *
     * @return Reprezentarea textuală a vehiculului.
     */
    @Override
    public abstract String toString();

    /**
     * Returnează coordonata X a vehiculului.
     *
     * @return Coordonata X.
     */
    public int getX() {
        return x;
    }

    /**
     * Returnează coordonata Y a vehiculului.
     *
     * @return Coordonata Y.
     */
    public int getY() {
        return y;
    }
}

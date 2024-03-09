/**
 * Clasa Depot reprezintă un depozit care poate conține mai multe vehicule.
 */
public class Depot {

    private Vehicle[] cars = new Vehicle[100];
    private int ID;
    private int x, y;
    private String name;

    /**
     * Constructorul clasei Depot.
     * @param ID Identificatorul unic al depozitului.
     * @param name Numele depozitului.
     * @param x Coordonata x a locației depozitului.
     * @param y Coordonata y a locației depozitului.
     */
    public Depot(int ID, String name, int x, int y) {
        this.ID = ID;
        this.name = name;
        this.x = x;
        this.y = y;
        // addCars(Masina);
    }
    /**
     * Adaugă un vehicul în lista de vehicule ale depozitului.
     * @param Masina Vehiculul care urmează să fie adăugat.
     */
    public void addCars(Vehicle Masina){
        for(int i = 0; i<cars.length; i++){
            if(cars[i] == null){
                cars[i] = Masina;
                return;
            }

        }
    }

    /**
     * Returnează lista de vehicule ale depozitului.
     * @return Array-ul de vehicule.
     */
    public Vehicle[] getCars() {
        return cars;
    }

    /**
     * Obține ID-ul depozitului.
     * @return ID-ul depozitului.
     */
    public int getID() {
        return ID;
    }

    /**
     * Obține numele depozitului.
     * @return Numele depozitului.
     */
    public String getName() {
        return name;
    }
    /**
     * Returnează o reprezentare sub formă de string a depozitului și a vehiculelor sale.
     * @return O reprezentare string a depozitului.
     */
    @Override
    public String toString(){
        String s;
        s = "Depozitul " + this.getName() + " are masinile: ";
        for(Vehicle car : cars){
            if (car != null) { // Adaugă această verificare pentru a evita NullPointerException
                s = s + car.getName() + "\n";
            }
        }
        return s;
    }
    /**
     * Verifică dacă două depozite sunt egale pe baza numelui.
     * @param d Depozitul cu care se compară.
     * @return True dacă numele depozitelor sunt identice, altfel False.
     */
    public boolean Equals(Depot d){
        return this.getName().equals(d.getName());
    }
    /**
     * Obține coordonata x a locației depozitului.
     * @return Coordonata x.
     */
    public int getX() {
        return x;
    }
    /**
     * Obține coordonata y a locației depozitului.
     * @return Coordonata y.
     */
    public int getY() {
        return y;
    }
}

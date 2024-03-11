import java.time.LocalTime;
/**
 * Reprezintă un client care poate fi asignat vehiculelor pentru livrări.
 */

public class Client {

    // Variabile de instanță și constructor


    /**
     * Numele clientului.
     */
    private String name;
    /**
     * ID-ul clientului.
     */
    private int id;
    /**
     * Coordonatele clientului
     */
    private int x, y;

    /**
     * Tipul clientului, acesta poate fi regular sau premium
     */
    public enum ClientType {
        REGULAR,
        PREMIUM;
    }

    private ClientType type;
    /**
     * Ora minima de ajuns la client
     */
    private LocalTime minTime;
    /**
     * Ora maxima de ajungere la client
     */
    private LocalTime maxTime;

    /**
     * Constructor pentru Client.
     * @param name numele clientului
     * @param minTime ora minimă la care clientul este disponibil pentru livrare
     * @param maxTime ora maximă până la care livrarea trebuie finalizată
     * @param type tipul clientului (REGULAR sau PREMIUM)
     * @param id id-ul clientului
     * @param x X-ul locației clientului
     * @param y Y-ul locației clientului
     */
    public Client(String name, LocalTime minTime, LocalTime maxTime, ClientType type, int id, int x, int y){
        this.name = name;
        this.minTime = minTime;
        this.maxTime = maxTime;
        this.type = type;
        this.id = id;
        this.x = x;
        this.y = y;
    }


    /**
     * Returneaza numele clientului
     * @return numele clientului
     */
    public String getName() {
        return name;
    }

    /**
     * Seteaza numele clientului
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return ora minima la care trebuie ajuns
     */
    public LocalTime getMinTime() {
        return minTime;
    }
    /**
     * Seteaza ora minima la care sa se poata ajunge
     */
    public void setMinTime(LocalTime minTime) {
        this.minTime = minTime;
    }
    /**
     * O metoda care va returna ora maxima de ajungere a clientului
     */
    public LocalTime getMaxTime() {
        return maxTime;
    }
    /**
     * Seteaza ora maxima la care sa se poata ajunge
     */
    public void setMaxTime(LocalTime maxTime) {
        this.maxTime = maxTime;
    }
    /**
     * O metoda care va returna tipul clientului
     * @return  tipul clientului.
     */
    public ClientType getType() {
        return type;
    }
    /**
     * Seteaza tipul clientului.
     */
    public void setType(ClientType type) {
        this.type = type;
    }
    /**
     * O metoda care va returna ID-ul clientului
     * @return id-ul clientului
     */
    public int getId() {
        return id;
    }

    /**
     * O metoda care va returna coordonata X a clientului
     * @return x-ul clientului
     */
    public int getX() {
        return x;
    }
    /**
     * O metoda care va returna coordonata Y a clientului
     * @return y-ul clientului
     */
    public int getY() {
        return y;
    }

    /**
     * O metodă pentru a returna o reprezentare
     * textuală a vehiculului.
     *
     * @return Reprezentarea textuală a clientului.
     */
    @Override
    public String toString(){
        return name;
    }
    public boolean Equals(Client c){
        return this.getName().equals(c.getName());
    }

}

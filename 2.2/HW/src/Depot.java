public class Depot {

    private Vehicle[] cars = new Vehicle[100];
    private int ID;
    private int x, y;
    private String name;

    public Depot(int ID, String name, int x, int y) {
        this.ID = ID;
        this.name = name;
        this.x = x;
        this.y = y;
        // addCars(Masina);
    }

    public void addCars(Vehicle Masina){
        for(int i = 0; i<cars.length; i++){
            if(cars[i] == null){
                cars[i] = Masina;
                return;
            }

        }
    }

    public Vehicle[] getCars() {
        return cars;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }
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
    public boolean Equals(Depot d){
        return this.getName().equals(d.getName());
    }


}

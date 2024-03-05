public class Depot {
    private String name;
    private Vehicle garaj[] = new Vehicle[100];

    public Depot(String name, Vehicle car1, int maxCapacity) {
        this.name = name;
        this.garaj = garaj;
        this.maxCapacity = maxCapacity;
        this.howMany++;
        garaj[howMany] = car1;
    }
    public Depot(String name, int maxCapacity) {
        this.name = name;
        this.garaj = garaj;
        this.maxCapacity = maxCapacity;
    }

    private int howMany = 0;
    private int maxCapacity;

    public Vehicle[] getGaraj() {
        return garaj;
    }

    public int getHowMany() {
        return howMany;
    }


    public void addCar(Vehicle car){
        this.howMany++;
        garaj[howMany] = car;
    }
    public void removeCar(int who){
        // 1 0 0 1 2 3
        // 1 0 1 0 2
        for(int i = who; i<=howMany; i++){
            Vehicle aux = garaj[i];
            garaj[i] = garaj[i+1];
            garaj[i+1] = aux;
            this.howMany--;
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        return "Depot " + name + " has " + howMany + " cars ";
    }


}

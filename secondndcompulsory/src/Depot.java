public class Depot {
    public Depot(Vehicle car1) {
        this.howMany++;
        garaj[howMany] = car1;

    }

    private Vehicle garaj[] = new Vehicle[100];
    private int howMany = 0;
}

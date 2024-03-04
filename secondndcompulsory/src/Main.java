public class Main {
    public static void main(String[] args) {

       Depot depou1 = new Depot("Ikea", 20);
        Vehicle Mercedes = new Vehicle("Porche", depou1);
        depou1.addCar(Mercedes);

    }
}
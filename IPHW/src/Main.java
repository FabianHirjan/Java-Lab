public class Main {
    public static void main(String[] args) {
        Ionescu myIonescu = new Ionescu(new Masina("Toyota","Neagra", 120));
        myIonescu.ShowCars();

        System.out.println(myIonescu.getNume());
    }
}
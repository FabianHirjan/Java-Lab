public class Ionescu extends Persoana {
    public Ionescu(Masina m) {
        this.addCar(m);
    }

    @Override
    String getNume() {
        return "Ionescu";
    }
}

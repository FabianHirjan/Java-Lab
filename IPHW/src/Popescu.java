public class Popescu extends Persoana{
    public Popescu(Masina m, Masina n) {
        this.addCar(m);
        this.addCar(n);
    }
    @Override
    String getNume() {
        return "Popescu";
    }
}

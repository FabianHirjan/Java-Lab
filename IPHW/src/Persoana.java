public abstract class Persoana {
    private Masina garaj[] = new Masina[100];
    private int contor = 0;

    public boolean addCar(Masina x){
        garaj[contor] = x;
        contor++;
        return true;
    }


    public void ShowCars(){
        for(int i = 0; i<contor; i++) {
            System.out.println(garaj[i].getProducator() + " " + garaj[i].getCuloare() + " " + garaj[i].getPutere() + "\n");
        }
    }

    abstract String getNume();
}

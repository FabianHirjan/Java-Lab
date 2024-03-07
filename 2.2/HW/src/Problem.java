public class Problem {
    private Depot[] depots = new Depot[100];
    public void addDepot(Depot d){
        for(int i = 0; i<depots.length; i++){
            if(depots[i] != null && depots[i].Equals(d)){
                System.out.println("Deja egzista depozitul fram");
                return;
            }
            if(depots[i] == null){
                depots[i] = d;
                return;
            }

        }
    }
    public Vehicle[] getVehicles(){
        Vehicle[] masini = new Vehicle[300];
        int index = 0;
        for(int k = 0; k<depots.length; k++){
            if(depots[k] != null){
                for(int j = 0; j<depots[k].getCars().length; j++){
                    if(depots[k].getCars()[j]!=null){
                        masini[index++] = depots[k].getCars()[j];
                    }
                }
            }
        }
        return masini;
    }

}

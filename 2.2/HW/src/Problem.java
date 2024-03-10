/**
 * Rezolva problema asignarii de vehicule in distanta cea mai apropiata fata de depozite
 */
public class Problem {
    /**
     * Array de depoturi
     */
    private Depot[] depots = new Depot[100];
    /**
     * Array de clienti care vor aparea in problema
     */
    private Client[] clients = new Client[100];
    /**
     * Adaugă un depozit la problemă dacă acesta nu există deja.
     * @param d depozitul de adăugat
     */
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
    /**
     * Adaugă un client la problemă dacă acesta nu există deja.
     * @param c clientul de adăugat
     */
    public void addClient(Client c){
        for(int i = 0; i<clients.length; i++){
            if(clients[i] != null && clients[i].Equals(c)){
                System.out.println("Deja egzista clientul fram");
                return;
            }
            if(clients[i] == null){
                clients[i] = c;
                return;
            }

        }
    }
    /**
     * Returneaza toate vehiculele din toate depozitele.
     * @return un array de vehicule
     */
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

    /**
     * Asignează vehiculele clienților pe baza distantei dintre acestia.
     */
    public void assign(){
        Vehicle[] vehicles = getVehicles();
        boolean[] assignedClients = new boolean[clients.length];

        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] != null) {


                double minDistance = Double.MAX_VALUE;
                int closestClientIndex = -1;

                for (int j = 0; j < clients.length; j++) {
                    if (!assignedClients[j] && clients[j] != null) {
                        double distance = distance(vehicles[i], clients[j]);
                        if (distance < minDistance) {
                            minDistance = distance;
                            closestClientIndex = j;
                        }
                    }
                }


                if (closestClientIndex != -1) {
                    System.out.println("Assigning Vehicle " + vehicles[i].getName() + " to Client " + clients[closestClientIndex].getName());
                    assignedClients[closestClientIndex] = true;
                }
            }
        }
    }
    /**
     * Calculează distanța dintre un vehicul și un client.
     * @param v vehiculul
     * @param c clientul
     * @return distanța de tip double
     */
    private double distance(Vehicle v, Client c) {
        return Math.sqrt(Math.pow(v.getX() - c.getX(), 2) + Math.pow(v.getY() - c.getY(), 2));
    }
    /**
     * Returneaza vectorul de depouri
     * @return array ul de depots.
     */
    public Depot[] getDepots() {
        return depots;
    }
    /**
     * Returneaza vectorul de clienti
     * @return array ul de clienti.
     */
    public Client[] getClients() {
        return clients;
    }
}

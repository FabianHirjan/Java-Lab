import java.time.LocalTime;
/**
 * Clasa Main este punctul de intrare pentru a demonstra funcționarea vehiculelor, depozitelor și asignarea clienților.
 */
public class Main {
    public static void main(String[] args) {
        Depot d = new Depot(0, "Marfar", 5, 10);
        Depot f = new Depot(0, "Traine", 5, 10);
        Drone Drona = new Drone(d, "Iao", 2, 100);
        Truck Camion = new Truck(f, "Scania", 3, 70);
        Truck Coco = new Truck(f, "Muie", 3, 70);
        Client c = new Client("Ionescu", LocalTime.NOON, LocalTime.MIDNIGHT, Client.ClientType.REGULAR, 0, 0, 0);
        Client c1 = new Client("Popescu", LocalTime.NOON, LocalTime.MIDNIGHT, Client.ClientType.REGULAR, 5,5, 6);
        Client c2 = new Client("Iao", LocalTime.NOON, LocalTime.MIDNIGHT, Client.ClientType.REGULAR, 4,3, 7);
        Client c3 = new Client("Dumio", LocalTime.NOON, LocalTime.MIDNIGHT, Client.ClientType.REGULAR, 1,2, 0);
        d.addCars(Camion);
        d.addCars(Coco);
        f.addCars(Drona);
        //System.out.println(d);
        Problem p = new Problem();
       p.addDepot(d);
       p.addDepot(f);
       p.addClient(c);
       p.addClient(c1);
        //System.out.println(p.getVehicles());
        Vehicle[] vec = p.getVehicles();
        /*
        for(int i = 0; i<vec.length; i++)
            if(vec[i]!=null)
            System.out.println(vec[i].getName());
         */
        p.assign();
    }
}
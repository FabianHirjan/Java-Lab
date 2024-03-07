public class Main {
    public static void main(String[] args) {
        Depot d = new Depot(0, "Marfar", 5, 10);
        Depot f = new Depot(0, "Traine", 5, 10);
        Drone Drona = new Drone(d, "Iao", 2, 100);
        Truck Camion = new Truck(f, "Scania", 3, 70);
        Truck Coco = new Truck(f, "Muie", 3, 70);
        d.addCars(Camion);
        d.addCars(Coco);
        f.addCars(Drona);
        //System.out.println(d);
        Problem p = new Problem();
       p.addDepot(d);
       p.addDepot(f);
        //System.out.println(p.getVehicles());
        Vehicle[] vec = p.getVehicles();
        for(int i = 0; i<vec.length; i++)
            if(vec[i]!=null)
            System.out.println(vec[i].getName());
    }
}
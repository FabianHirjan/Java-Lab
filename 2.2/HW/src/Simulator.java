//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.time.LocalTime;
import java.util.Random;

public class Simulator {
    private final int width;
    private final int height;
    private char[][] map;
    private static final char DEPOT_SYMBOL = '●';
    private static final char CLIENT_SYMBOL = '◯';
    private Client[] clients = new Client[100];
    private Depot[] depots = new Depot[100];
    private Random random = new Random();

    public Simulator(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new char[height][width];
    }

    public void generateClientsAndDepots() {
        this.generateClients();
        this.generateDepots();
    }

    private void generateClients() {
        for(int i = 0; i < this.clients.length; ++i) {
            String name = "Client" + i;
            LocalTime minTime = LocalTime.of(this.random.nextInt(24), this.random.nextInt(60));
            LocalTime maxTime = LocalTime.of(this.random.nextInt(24), this.random.nextInt(60));
            Client.ClientType type = Client.ClientType.values()[this.random.nextInt(Client.ClientType.values().length)];
            int x = this.random.nextInt(this.width);
            int y = this.random.nextInt(this.height);
            this.clients[i] = new Client(name, minTime, maxTime, type, i, x, y);
            this.map[y][x] = 9711;
        }

    }

    private void generateTrucks(Depot d, int numTrucks) {
        for(int i = 0; i < numTrucks; ++i) {
            String name = "Truck" + i;
            int location = this.random.nextInt(100);
            int capacity = this.random.nextInt(100);
            Truck truck = new Truck(d, name, location, capacity);
            d.addCars(truck);
        }

    }

    private void generateDepots() {
        for(int i = 0; i < this.depots.length; ++i) {
            String name = "Depot" + i;
            int x = this.random.nextInt(this.width);
            int y = this.random.nextInt(this.height);
            Depot d = new Depot(i, name, x, y);
            this.depots[i] = d;
            this.map[y][x] = 9679;
            this.generateTrucks(d, 3);
        }

    }

    public void displayMap() {
        for(int y = 0; y < this.height; ++y) {
            for(int x = 0; x < this.width; ++x) {
                System.out.print(this.map[y][x] + " ");
            }

            System.out.println();
        }

    }

    public void solveProblem() {
        Problem problem = new Problem();
        Depot[] var2 = this.depots;
        int var3 = var2.length;

        int var4;
        for(var4 = 0; var4 < var3; ++var4) {
            Depot depot = var2[var4];
            problem.addDepot(depot);
        }

        Client[] var6 = this.clients;
        var3 = var6.length;

        for(var4 = 0; var4 < var3; ++var4) {
            Client client = var6[var4];
            problem.addClient(client);
        }

        problem.assign();
    }
}

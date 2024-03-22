import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Main {
    Person[] persons = IntStream.rangeClosed(0, 9)
            .mapToObj(i -> new Person("P" + i, (int) (Math.random() * 40 + 20), "D" + (i % 3)))
            .toArray(Person[]::new);

    Map<Boolean, List<Person>> partitioned = Arrays.stream(persons)
            .collect(Collectors.partitioningBy(person -> Math.random() < 0.5));

    List<Driver> drivers = partitioned.get(true).stream()
            .map(person -> new Driver(person.getName(), person.getAge(), person.getDestination()))
            .collect(Collectors.toList());

    List<Passenger> passengers = partitioned.get(false).stream()
            .map(person -> new Passenger(person.getName(), person.getAge(), person.getDestination()))
            .collect(Collectors.toList());

        System.out.println("Matches:");
        drivers.forEach(driver -> passengers.stream()
            .filter(passenger -> !passenger.isMatched() && driver.getDestination().equals(passenger.getDestination()))
            .findFirst()
                .ifPresent(passenger -> {
        driver.setMatched(true);
        passenger.setMatched(true);
        System.out.println("Driver " + driver.getName() + " matches with " + "passenger " +passenger.getName());
    }));

    LinkedList<Driver> sortedDrivers = drivers.stream()
            .sorted(Comparator.comparingInt(Driver::getAge))
            .collect(Collectors.toCollection(LinkedList::new));

    TreeSet<Passenger> sortedPassengers = new TreeSet<>(Comparator.comparing(Passenger::getName));
        sortedPassengers.addAll(passengers);

        System.out.println();
        System.out.println("Sorted Drivers:");
        sortedDrivers.forEach(System.out::println);

        System.out.println();
        System.out.println("Sorted Passengers:");
        sortedPassengers.forEach(System.out::println);

}
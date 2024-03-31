package org.example;

import com.github.javafaker.Faker;
import shell.Shell;
import java.io.IOException; // Pentru IOException
import java.util.stream.IntStream;

import java.io.StringWriter;



public class Main {
    public static void main(String[] args) throws Exception {
        Faker faker = new Faker();
        Operations o = new Operations();

        Person[] persons = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Person(faker.name().lastName(), i))
                .toArray(Person[]::new);
        /*
        try {
            o.makeDir();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
*/
        /*
        try {
            o.make(persons);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/

        Shell shell = new Shell();
        shell.run();

        try{
            o.displayDirectoryContent("/Users/fabian-andreihirjan/Desktop/Path/");
        }catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter person's name: ");
        String personName = scanner.nextLine();
        System.out.println("Enter document's name: ");
        String documentName = scanner.nextLine();

        Person person = new Person(personName, 0);
        Document document = new Document(documentName);

        try {
            o.addDocumentToPerson(person, document);
        } catch (IOException e) {
            e.printStackTrace(); // sau altă acțiune dorită
        }
        */

    }

}
package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Masina ferrari = new Masina();
        System.out.println(ferrari.getHp());
        Masina lambo = new Masina();


        List<Masina> cars = new ArrayList<>();
        cars.add(ferrari);

        HashMap<String, Masina> halo = new HashMap<>();
        halo.put("Pula", lambo);
        System.out.println(halo.get("Pula").getHp());

        // Crearea unei instanțe a clasei LinkedList
        LinkedList<Integer> list = new LinkedList<>();

        // Adăugarea elementelor la lista
        list.add(1);
        list.add(2);
        list.add(3);

        // Afișarea listei
        System.out.println("LinkedList: " + list);

        // Ștergerea unui element
        list.remove(1);
        list.add(6);

        // Afișarea listei după ștergere
        System.out.println("After deleting element: " + list);


    }
}
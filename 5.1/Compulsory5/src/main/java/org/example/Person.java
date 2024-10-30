package org.example;

public record Person(String name, int id) {
    private static int nextId = 1;

    public static Person createPerson(String name) {
        return new Person(name, nextId++);
    }
}
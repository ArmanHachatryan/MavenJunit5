package org.aston.exercise;

import org.aston.exercise.subFactory.FordFactory;
import org.aston.exercise.subFactory.ToyotaFactory;

public class Main {
    public static void main(String[] args) {
        CarsFactory factory;
        factory = new ToyotaFactory();

        factory.createCoupe();
        factory.createSedan();
    }
}
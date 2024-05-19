package org.aston.exercise.subFactory;

import org.aston.exercise.CarsFactory;
import org.aston.exercise.carType.Coupe;
import org.aston.exercise.carType.FordCoupe;
import org.aston.exercise.carType.FordSedan;
import org.aston.exercise.carType.Sedan;

public class FordFactory implements CarsFactory {

    @Override
    public Sedan createSedan() {
        return new FordSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new FordCoupe();
    }
}

package org.aston.exercise.subFactory;

import org.aston.exercise.CarsFactory;
import org.aston.exercise.carType.Coupe;
import org.aston.exercise.carType.Sedan;
import org.aston.exercise.carType.ToyotaCoupe;
import org.aston.exercise.carType.ToyotaSedan;

public class ToyotaFactory implements CarsFactory {
    @Override
    public Sedan createSedan() {
        return new ToyotaSedan();
    }

    @Override
    public Coupe createCoupe() {
        return new ToyotaCoupe();
    }
}

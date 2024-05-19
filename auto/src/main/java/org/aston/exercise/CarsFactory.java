package org.aston.exercise;

import org.aston.exercise.carType.Coupe;
import org.aston.exercise.carType.Sedan;

public interface CarsFactory {
    Sedan createSedan();
    Coupe createCoupe();
}

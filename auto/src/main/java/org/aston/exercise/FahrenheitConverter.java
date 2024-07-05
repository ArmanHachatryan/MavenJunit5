package org.aston.exercise;

public class FahrenheitConverter extends BaseConverter{
    //(0 °C × 9/5) + 32 = 32 °F
    @Override
    public Double convert(double celsius) {
        return (celsius * (9/5) + 32);
    }
}

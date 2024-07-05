package org.aston.exercise;

public class KelvinConverter extends BaseConverter{

    // 0 °C + 273,15 = 273,15 K
    @Override
    public Double convert(double celsius) {
        return celsius + 273.15;
    }
}

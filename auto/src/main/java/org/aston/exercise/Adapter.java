package org.aston.exercise;

public class Adapter {

    public final BaseConverter converter;

    public Adapter(BaseConverter _converter) {
        converter = _converter;
    }

    public Double convertTo(Double celsius ) {
        return converter.convert(celsius);
    }
}

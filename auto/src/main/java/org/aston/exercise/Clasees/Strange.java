package org.aston.exercise.Clasees;

import java.util.Comparator;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Strange {
    public static void main(String[] args) {
        int a = 12356;
        System.out.println(a/100 + "Rub, " + a%100 + "K");



        Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(5,3,7,4,8);
        var min = streamSupplier.get().min(Comparator.naturalOrder());
        var max = streamSupplier.get().max(Comparator.naturalOrder());
    }
}

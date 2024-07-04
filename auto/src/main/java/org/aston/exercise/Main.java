package org.aston.exercise;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Supplier<Stream<Integer>> streamSupplier = () -> Stream.of(5,3,7,4,8);
        var min = streamSupplier.get().min(Comparator.naturalOrder());
        var max = streamSupplier.get().max(Comparator.naturalOrder());
    }
}
       
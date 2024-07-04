package org.aston.exercise.Clasees;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Distinct {

    public static Set<Integer> distinct(int[] numbers) {
        Set<Integer> result = new HashSet<>();
        for (int n : numbers) result.add(n);
        return result;
    }

    public static List<Integer> distinct2(int[] sortedList) {
        return Arrays.stream(sortedList).boxed().distinct().collect(Collectors.toList());
    }

    public static List<Integer> distinct3(Stream<Integer> stream) {
        return stream.distinct().collect(Collectors.toList());
    }

    public static Set<Integer> distinct4(int[] sortedList) {
        Set<Integer> uniqueList = new HashSet<>();
        for (var key : sortedList) {
            uniqueList.add(key);
        }
        return uniqueList;
    }
}
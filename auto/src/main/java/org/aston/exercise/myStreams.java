package org.aston.exercise;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class myStreams {

    //поиск мин и макс
    public static int getMin(Stream<Integer> stream) {
        return stream.mapToInt(x -> x).min().getAsInt();
    }

    public static Integer getMax(Stream<Integer> stream) {
        return stream.max(Integer::compare).get();
    }

    public static Set<Integer> distinct2(int[] num) {
        Set<Integer> distinct = new HashSet<>();
        for (int n : num) {
            distinct.add(n);
        }
        return distinct;
    }

    public static List<Integer> distinct3(int[] sortedList) {
        return Arrays.stream(sortedList).boxed().distinct().collect(Collectors.toList());
    }

    public static List<Integer> distinct(Stream<Integer> stream) {
        return stream.distinct().collect(Collectors.toList());
    }

    public static Set<Integer> distinct(int[] sortedList) {
        Set<Integer> uniqueList = new HashSet<>();

        for (var key : sortedList) {
            uniqueList.add(key);
        }

        return uniqueList;
    }

    public static List<Integer> chetNeChet(Stream<Integer> stream) {
        return stream.map(i -> i % 2 == 0 ? i * 100 : i - 100).collect(Collectors.toList());
    }
}

package org.aston.exercise;

import java.util.*;
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
    public static Integer min(int[] nums) {
        return Arrays.stream(nums).min().orElseThrow(RuntimeException::new);
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

    public static List<Integer> reverse(Stream<Integer> stream) {
        //return stream.sorted((a,b) -> new myComp().compare(a,b)).collect(Collectors.toList());
        //return stream.sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return stream.sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int answer;
                if (o1 == o2) answer = 0;
                else if (o1 > o2) answer = 1;
                else answer = -1;
                return -1 * answer;
            }
        }).collect(Collectors.toList());
    }

    private static void sum(int[] nums) {
        //return Arrays.stream(nums).filter(x -> (x % 2 != 0)).sum();
        Arrays.stream(nums).boxed().mapToInt(x -> x % 2 == 0 ? x + 100 : x - 100).forEach(System.out::println);
    }
}

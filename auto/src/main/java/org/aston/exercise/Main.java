package org.aston.exercise;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {


//        // 1, 2, 3, 4, 5, 15
//        int sum = Stream.of(1, 2, 3, 4, 5, 15)
//                .filter(x -> x % 2 != 0)
//                .mapToInt(x -> x).sum();
//
//        int sum2 = Stream.of(1, 2, 3, 4, 5, 15)
//                .filter(x -> x % 2 != 0).reduce(Integer::sum)
//                        .orElseThrow(RuntimeException::new);
//
//        System.out.println(sum + " " + sum2);
//
//        List<String> list = new ArrayList<>();
//        list.add("Афанасий");
//        list.add("Петров");
//        list.add("Гражулис");
//
//        list.stream()
//                .filter(x -> x.startsWith("А"))
//                .collect(Collectors.toList());
//


        //33, 65, 1, 94, 50
//        var result = Stream.of(33, 65, 1, 94, 50).min(Integer::compareTo).get();
//
//        System.out.println("Min value : " + result);
//
//        Stream<Integer> integerStream = Stream.of(33, 65, -5, 94, 50);

        //Пеняет ключи и значения в hashMap местами

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Value1");
        map.put(2, "Value2");
        map.put(3, "Value3");
        map.put(4, "Value4");

        Map<String, Integer> mapTwo = new HashMap<>();

        for (var entity : map.entrySet()) {
            mapTwo.put(entity.getValue(), entity.getKey());
        }

        System.out.println(map);
        System.out.println(mapTwo);

    }
}
package org.aston.exercise.Clasees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Fibonacci {
    public static Integer fibonachi3(int index) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 0, 1);
        for (int i = 2; i < index + 1; i++) {
            list.add(i, list.get(i - 2) + list.get(i - 1));
        }
        return list.get(index);
    }

    public static Integer fibonachi2(int index) {
        int[] numbers = new int[index + 1];
        numbers[0] = 0;
        numbers[1] = 1;
        for (int i = 2; i < numbers.length; i++) {
            numbers[i] = numbers[i - 2] + numbers[i - 1];
        }
        return numbers[index];
    }


    public static void fibonachi() {
        int k = 11;
        int[] numbers = new int[k];
        numbers[1] = 1;
        numbers[2] = 1;
        for (int i = 3; i < numbers.length; i++) {
            numbers[i] = numbers[i - 2] + numbers[i - 1];
        }

        System.out.println(Arrays.stream(numbers).sum()); //мой варик

        //Димин
        int sum = Stream.iterate(new int[]{0, 1}, array -> new int[]{array[1], array[0] + array[1] })
                .limit(k)
                .map(x -> x[0])
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println(Arrays.toString(numbers));
        System.out.println(sum);
    }
}

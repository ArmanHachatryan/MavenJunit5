package org.aston.exercise.Clasees;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaxMin {
    public static int getMax(int[] nums) {
        int max = nums[0];
        for (var key : nums) {
            if (max < key) {
                max = key;
            }
        }
        return max;
    }

    public static int getMin(Stream<Integer> stream) {
        return stream.mapToInt(x -> x).min().getAsInt();
    }

    public static Integer getMax(Stream<Integer> stream) {
        return stream.max(Integer::compare).get();
    }
    public static Integer min(int[] nums) {
        return Arrays.stream(nums).min().orElseThrow(RuntimeException::new);
    }
}

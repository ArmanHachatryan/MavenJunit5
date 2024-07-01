package org.aston.exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Cycle {
    //макс число из массива взять
    public static int getMax(int[] nums) {
        int max = nums[0];
        for (var key : nums) {
            if (max < key) {
                max = key;
            }
        }

        return max;
    }

    public static Map<String, Integer> reverseKeyValue(Map<Integer, String> firstMap) {
        Map<String, Integer> secondMap = new HashMap<>();
        for (Map.Entry<Integer, String> set : firstMap.entrySet()){
            secondMap.put(set.getValue(), set.getKey());
        }
        return secondMap;
    }


}

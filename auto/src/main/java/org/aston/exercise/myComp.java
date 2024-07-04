package org.aston.exercise;

import java.util.Comparator;

public class myComp implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        int answer;
        if (o1 == o2) answer = 0;
        else if (o1 > o2) answer = 1;
        else answer = -1;
        return -1 * answer;
    }
}

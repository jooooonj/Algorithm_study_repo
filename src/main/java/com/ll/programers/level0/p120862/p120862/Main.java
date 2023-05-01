package com.ll.programers.level0.p120862.p120862;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] numbers) {
        Arrays.sort(numbers);
        int max = numbers[0] * numbers[1];
        int max2 = numbers[numbers.length - 1] * numbers[numbers.length - 2];
        if (max > max2) {
            return max;
        } else
            return max2;
    }
}

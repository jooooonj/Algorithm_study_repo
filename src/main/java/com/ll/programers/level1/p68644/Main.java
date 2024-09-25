package com.ll.programers.level1.p68644;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<numbers.length - 1; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        int[] arr = new int[list.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }

        return arr;
    }
}
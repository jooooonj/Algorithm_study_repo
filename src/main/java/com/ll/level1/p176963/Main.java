package com.ll.level1.p176963;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"}, {"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
        Solution s = new Solution();
        int[] result = s.solution(name, yearning, photo);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> map = new HashMap<>();

        int[] result = new int[photo.length];

        for(int i=0; i<name.length; i++){
            map.put(name[i], yearning[i]);
        }

        for(int i=0; i<photo.length; i++){

            for(int j=0; j<photo[i].length; j++){
                result[i] += map.getOrDefault(photo[i][j], 0);
            }
        }

        return result;
    }
}
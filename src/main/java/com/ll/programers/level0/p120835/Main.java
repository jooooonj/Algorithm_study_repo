package com.ll.programers.level0.p120835;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.solution(new int[]{3, 76, 24});
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(int[] emergency) {
        int[] arr = emergency.clone();
        int[] result = new int[emergency.length];

        Arrays.sort(emergency);

        for (int i = emergency.length - 1; i >= 0; i--) {

            for(int j=0; j<emergency.length; j++){
                if(emergency[i]==arr[j]){
                    result[j] = emergency.length-i;
                }
            }
        }
        return result;

    }
}
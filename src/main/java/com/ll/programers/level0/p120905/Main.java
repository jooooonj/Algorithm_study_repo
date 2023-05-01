package com.ll.programers.level0.p120905;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(3, new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12});
        System.out.println(Arrays.toString(solution));
    }
}

class Solution {
    public int[] solution(int n, int[] numlist) {
        int[] arr = new int[100];
        int index = 0;
        for(int i=0; i<numlist.length; i++){
            if(numlist[i]%n==0){
                arr[index++] = numlist[i];
            }
        }

        int[] result = new int[index];
        for(int i=0; i<index; i++){
            result[i] = arr[i];
        }
        return result;
    }
}

package com.ll.level0.p120812;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int solution(int[] array) {
        int[] arr = new int[1001];

        for(int i=0; i<array.length; i++){
            arr[array[i]]++;
        }

        int max = Integer.MIN_VALUE;
        int result = -1;
        int maxCount = 0;
        for(int i=0; i<arr.length; i++) {
            if(max < arr[i]){
                max = arr[i];
                result = i;
                maxCount = 0;
            } else if(max == arr[i]){
                maxCount++;
            }
        }
        if(maxCount > 0)
            return -1;
        return result;

    }
}

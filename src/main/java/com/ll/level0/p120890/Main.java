package com.ll.level0.p120890;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] array, int n) {
        int minus = Integer.MAX_VALUE;
        int result = 0;
        for(int i=0; i<array.length; i++){
            int num = Math.abs(array[i] - n);
            if (minus > num) {
                minus = num;
                result = array[i];
            } else if (minus == num) {
                result = result > array[i] ? array[i] : result;
            }
        }
        return result;
    }
}
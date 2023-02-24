package com.ll.level0.p120583;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] array, int n) {
        int count = 0;

        for(int i=0; i<array.length; i++){
            if(array[i] == n) count++;
        }
        return count;
    }
}
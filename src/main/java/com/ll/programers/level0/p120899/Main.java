package com.ll.programers.level0.p120899;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] array) {
        int[] arr = new int[2];
        int index = -1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<array.length; i++){
            if(max < array[i]){
                max = array[i];
                index = i;
            }
        }
        arr[0]= max;
        arr[1]= index;
        return arr;
    }
}

package com.ll.level0.p120809;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] numbers) {

        for(int i=0; i<numbers.length; i++){
            numbers[i] = numbers[i]*2;
        }

        return numbers;
    }
}
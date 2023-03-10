package com.ll.level0.p120843;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int solution(int[] numbers, int k) {
        int result = numbers[(k - 1) * 2 % numbers.length];
        return result;
    }
}

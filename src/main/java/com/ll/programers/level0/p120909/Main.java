package com.ll.programers.level0.p120909;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n) {
        int sqrt = (int) Math.sqrt(n);
        if(sqrt * sqrt == n)
            return 1;
        else
            return 2;
    }
}

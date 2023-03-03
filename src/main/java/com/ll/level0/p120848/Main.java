package com.ll.level0.p120848;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n) {
        if(n==0)
            return 0;
        int i = 1;
        int factorial = 1;
        while (true) {
            factorial *= i;
            if (factorial==n) {
                return i;
            } else if(factorial > n){
                return i-1;
            }
            i++;
        }
    }
}

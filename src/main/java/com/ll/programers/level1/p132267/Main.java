package com.ll.programers.level1.p132267;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int a, int b, int n) {
        int sum = 0;
        while(n >= a){
            sum += n/a * b;
            n = n/a * b + n%a;
        }

        return sum;
    }
}

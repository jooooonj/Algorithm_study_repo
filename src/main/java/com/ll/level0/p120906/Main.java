package com.ll.level0.p120906;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n) {
        int sum =0;

        while(n!=0){
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}
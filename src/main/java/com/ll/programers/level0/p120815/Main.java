package com.ll.programers.level0.p120815;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int result = s.solution(6);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int n) {
        int num = gcd(n, 6);
        return (n * 6) / num /6;

    }

    public int gcd(int a, int b){
        if(b==0)
            return a;
        else
            return gcd(b, a%b);
    }
}
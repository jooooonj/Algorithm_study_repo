package com.ll.level0.p120884;


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(1086);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int chicken) {
       int coupon = 0;
       int ch = chicken;
       int service = 0;
        while(coupon + ch >= 10){
            coupon += ch;
            ch = coupon / 10;
            service += ch;
            coupon -= ch * 10;
        }

        return service;
    }
}

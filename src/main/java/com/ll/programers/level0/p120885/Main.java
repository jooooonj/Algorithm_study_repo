package com.ll.programers.level0.p120885;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution("10", "11");
        System.out.println(result);
    }
}

class Solution {
    public String solution(String bin1, String bin2) {
        Integer a = Integer.valueOf(bin1, 2);
        Integer b = Integer.valueOf(bin2, 2);
        int c = a+b;
        String result = Integer.toBinaryString(c);
        return result;
    }
}
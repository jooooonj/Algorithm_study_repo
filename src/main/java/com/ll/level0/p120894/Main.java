package com.ll.level0.p120894;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        long result = s.solution("onetwothreefourfivesixseveneightnine");
        System.out.println(result);
    }
}

class Solution {
    public long solution(String numbers) {
        String[] num_english = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for(int i=0; i<num_english.length; i++){
           numbers = numbers.replaceAll(num_english[i], Integer.toString(i));
        }
        return Long.parseLong(numbers);
    }
}

package com.ll.programers.level1.p12930;



public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String result = s.solution("try hello world");
        System.out.println(result);
    }
}

class Solution {
    public String solution(String s) {
        String[] split = s.split("");

        String result = "";
        int index = 0;
        for(String ss : split){
            if(ss.equals(" ")){
                index = 0;
                result += " ";
            } else if (index % 2 == 0){
                result += ss.toUpperCase();
                index++;
            } else {
                result += ss.toLowerCase();
                index++;
            }
        }

        return result;
    }
}

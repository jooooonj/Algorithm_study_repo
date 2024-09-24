package com.ll.programers.level1.p142086;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(String s) {
        int[] result = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            boolean isMatch = false;
            for(int j=0; j<i; j++){
                char ch2 = s.charAt(j);
                if(ch == ch2){
                    result[i] = i - j;
                    isMatch = true;
                }
            }

            if(!isMatch){
                result[i] = -1;
            }
        }

        return result;
    }
}


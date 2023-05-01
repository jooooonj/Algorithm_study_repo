package com.ll.programers.level0.p120886;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(String before, String after) {
        int[] alpha = new int[26];
        int result = 1;
        for(int i=0; i<before.length(); i++){
            alpha[before.charAt(i) - 'a']++;
            alpha[after.charAt(i)-'a']--;
        }

        for(int i=0; i<alpha.length; i++){
            if (alpha[i] > 0) {
                result = 0;
                break;
            }
        }

        return result;
    }
}

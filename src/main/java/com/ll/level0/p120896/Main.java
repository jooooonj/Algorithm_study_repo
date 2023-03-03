package com.ll.level0.p120896;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String s) {
        int[] alpha = new int[26];
        String str = "";
        for(int i=0; i<s.length(); i++){
            alpha[s.charAt(i)-'a']++;
        }

        for(int i=0; i<alpha.length; i++){
            if(alpha[i]==1)
                str+=(char)(i+'a');
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String result = new String(chars);
        return result;
    }
}
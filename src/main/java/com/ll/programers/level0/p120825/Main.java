package com.ll.programers.level0.p120825;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String my_string, int n) {
        int len = my_string.length();
        String str = "";
        for(int i=0; i<len; i++){
            for(int j=0; j<n; j++){
                str+=my_string.charAt(i);
            }
        }
        return str;
    }
}

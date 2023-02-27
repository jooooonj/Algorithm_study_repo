package com.ll.level0.p120892;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String cipher, int code) {
        int len = cipher.length();
        String str = "";
        for(int i=code-1; i<len; i+=code){
            str += cipher.charAt(i);
        }
        return str;
    }
}

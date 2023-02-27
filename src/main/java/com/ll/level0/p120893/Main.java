package com.ll.level0.p120893;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String my_string) {
        int len = my_string.length();
        String str = "";
        for(int i=0; i<len; i++){
            char ch = my_string.charAt(i);
            if(ch >= 'a' && ch <= 'z'){
                ch = Character.toUpperCase(ch);
            } else if(ch >='A' && ch <= 'Z'){
                ch = Character.toLowerCase(ch);
            }
            str += ch;
        }

        return str;
    }
}
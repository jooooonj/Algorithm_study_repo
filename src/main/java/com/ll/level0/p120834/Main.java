package com.ll.level0.p120834;

public class Main {
    public static void main(String[] args) {
        char ch = '2';
        char ch2 = (char)(ch+'a');
        System.out.println(ch2);
    }
}

class Solution {
    public String solution(int age) {
        String str = Integer.toString(age);
        String result = "";
        for(int i=0; i<str.length(); i++){
            int a = str.charAt(i)-'0';
            char ch =(char)(a + 'a');
            result += ch;
        }
        return result;
    }
}
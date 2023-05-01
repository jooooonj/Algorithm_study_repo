package com.ll.programers.level0.p120895;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String my_string, int num1, int num2) {

        char ch = my_string.charAt(num1);
        char ch2 = my_string.charAt(num2);

        StringBuilder sb = new StringBuilder(my_string);
        sb.setCharAt(num1, ch2);
        sb.setCharAt(num2, ch);

        return sb.toString();
    }
}

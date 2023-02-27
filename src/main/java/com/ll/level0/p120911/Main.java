package com.ll.level0.p120911;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String my_string) {
        String s = my_string.toLowerCase();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}

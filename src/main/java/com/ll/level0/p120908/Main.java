package com.ll.level0.p120908;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(String str1, String str2) {
        boolean contains = str1.contains(str2);
        if(contains)
            return 1;
        else
            return 2;
    }
}

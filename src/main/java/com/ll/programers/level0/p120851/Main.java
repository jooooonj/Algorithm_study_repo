package com.ll.programers.level0.p120851;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(String my_string) {
        int len = my_string.length();
        int sum = 0;

        for(int i=0; i<len; i++){
            char ch = my_string.charAt(i);
            if(ch>='1' && ch<='9'){
                int a = ch - '0';
                sum += a;
            }
        }
        return sum;
    }
}
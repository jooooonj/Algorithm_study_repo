package com.ll.programers.level0.p120850;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(String my_string) {
        String str ="";

        for(int i=0; i<my_string.length(); i++){
            char ch = my_string.charAt(i);
            if(ch>='0' && ch <= '9'){
                str += ch;
            }
        }

        int[] arr = new int[str.length()];
        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i)-'0';
        }
        Arrays.sort(arr);
        return arr;
    }
}
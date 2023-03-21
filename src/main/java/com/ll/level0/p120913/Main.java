package com.ll.level0.p120913;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] result = s.solution("abcdef123", 3);
        System.out.println(Arrays.toString(result));
    }
}
class Solution {
    public String[] solution(String my_str, int n) {
        String[] strArr;
        int index = 0;
        if(my_str.length()%n > 0)
            strArr = new String[my_str.length() / n +1];
        else strArr = new String[my_str.length() / n];
        int i;
        for (i = 0; i+n < my_str.length(); i += n) {
            strArr[index++] = my_str.substring(i,i+n);
        }
        if(i!=my_str.length())
            strArr[index] = my_str.substring(i);
        return strArr;
    }
}
package com.ll.programers.level0.p120921;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution("hello", "ohell");
        System.out.println(result);
    }
}
class Solution {
    public int solution(String A, String B) {
        int count = 0;
        char[] chars = A.toCharArray();
        String result = "";
        while(A.length() >= count){
            if(String.valueOf(chars).equals(B)) {
                return count;
            }

            char tmp = chars[A.length() - 1];

            for(int i=chars.length -1 ; i>0; i--){
                chars[i] = chars[i - 1];
            }
            chars[0] = tmp;
            count++;

        }

        return -1;
    }
}

package com.ll.level0.p120888;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution("people");
        System.out.println(result);
    }
}

class Solution {
    public String solution(String my_string) {

        String str = "";
        for(int i=0; i<my_string.length(); i++){
            if(my_string.indexOf(my_string.charAt(i))==i)
                str += my_string.charAt(i);
        }
        return str;
    }
}

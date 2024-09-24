package com.ll.programers.level1.p147355;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("10203", "15");
    }
}

class Solution {
    public int solution(String t, String p) {
        int length = p.length();

        int cnt = 0;
        for(int i=0; i<t.length() - length + 1; i++){
            String subString = t.substring(i, i+length);

            var number = Long.parseLong(subString);
            if(number <= Long.parseLong(p)){
                cnt ++;
            }
        }

        return cnt;
    }
}

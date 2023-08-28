package com.ll.topInterview.leetcode3;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String str = "tmmzuxt";
        Solution s = new Solution();
        int num = s.lengthOfLongestSubstring(str);
        System.out.println(num);
    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right= 0;
        int max = Integer.MIN_VALUE;

        while(right < s.length()){
            char ch = s.charAt(right++);


            if(map.containsKey(ch)){ //만약 이미 있는 값이면
                while(s.charAt(left) != ch){
                    map.remove(s.charAt(left));
                    left++; //처음부터 그 친구 찾아서
                }
                left++;
            } else{
                map.put(ch, 1);
                max = Math.max(max, right - left);
            }
        }

        if(max == Integer.MIN_VALUE) return 0;
        return max;
    }
}

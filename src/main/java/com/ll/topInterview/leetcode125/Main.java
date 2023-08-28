package com.ll.topInterview.leetcode125;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public boolean isPalindrome(String s) {
        String s1 = s.toLowerCase().replaceAll("[^a-zA-Z0-9]", "");

        for(int i=0; i<s1.length()/2; i++){
            if(s1.charAt(i) != s1.charAt(s1.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}

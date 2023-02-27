package com.ll.level0.p120904;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(29183, 1);
        System.out.println(result+1);
    }
}
class Solution {
    public int solution(int num, int k) {
        String str = Integer.toString(num);
        System.out.println(str);
        int index = -2;
        char ch =(char)(k +'0');
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==ch){
                index = i;
                break;
            }
        }
        return index+1;
    }
}
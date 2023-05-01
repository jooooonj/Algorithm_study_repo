package com.ll.programers.level0.p120912;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] array) {
        int N = array.length;
        int count = 0;
        for(int i=0; i<N; i++){
            String str = Integer.toString(array[i]);
            for(int j=0; j<str.length(); j++){
                int num = str.charAt(j)-'0';
                if(num==7)
                    count++;
            }
        }
        return count;
    }
}

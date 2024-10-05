package com.ll.programers.level2.p12899;

public class Main {
}

class Solution {
    public String solution(int n) {
        int[] arr = {4,1,2};

        String answer = "";
        while(n > 0){
            answer = String.valueOf(arr[n%3]) + answer;
            n = (n-1)/3;
        }

        return answer;

    }
}

package com.ll.programers.level2.p42883;


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String number = "1924";
        int k = 2;
        s.solution(number, k);
    }
}

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        String[] numStrs = number.split("");

        int start = 0;
        for(int i=0; i<numStrs.length - k; i++){

            int max = 0;
            for(int j=start; j<=i+k; j++){
                String numStr = numStrs[j];
                int num = Integer.parseInt(numStr);
                if(max < num){
                    max = num;
                    start = j+1;
                }

                if(num == 9){
                    break;
                }
            }

            answer += max;
        }

        return answer;
    }
}
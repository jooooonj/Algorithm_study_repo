package com.ll.programers.level0.p120871;
/////////////////////마저 풀어야함 저주의 숫자 3
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int solution = s.solution(15);
        System.out.println(solution);
    }
}

class Solution {
    public int solution(int n) {
        int num = 1;
        for(int i=0; i<n; i++){

            while(num%3==0 || Integer.toString(num).contains("3")){
                num ++;
            }
            num ++;
        }

        return num -1 ;
    }
}

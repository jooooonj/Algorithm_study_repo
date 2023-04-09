package com.ll.level0.p120878;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int solution = s.solution(12, 21);
        System.out.println(solution);
    }
}
class Solution {
    public int solution(int a, int b) {
        int num = b / sss(b, a);

        while(num%5==0){
            num /= 5;
        }

        while(num % 2==0){
            num /= 2;
        }

        if(num==1)
            return 1;

        return 2;

    }

    public int sss(int a, int b){
        if(b==0)
            return a;
        return sss(b, a%b);
    }

}

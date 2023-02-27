package com.ll.level0.p120846;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(15);
        System.out.println(result);
    }
}
class Solution {
    public int solution(int n) {
        int[] prime = new int[n+1];
        int count = 0;

        for(int i=2; i<=n; i++){

            if(prime[i]==1)
                continue;

            for(int j=i*i; j<=n; j+=i){
                if(prime[j]!=1){
                    count++;
                }
                prime[j] = 1;

            }
        }

        return count;
    }
}

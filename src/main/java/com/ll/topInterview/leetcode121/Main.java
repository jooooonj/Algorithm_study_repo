package com.ll.topInterview.leetcode121;

public class Main {

}

class Solution {
    public int maxProfit(int[] prices) {

        int max = -1; //고점
        int profit = 0; //이익
        for(int i=prices.length-1; i>=0; i--){
            if(prices[i] > max){ // 고점 찾았으면 비교
                max = prices[i];
            } else{
                profit = Math.max(profit, max - prices[i]);
            }
        }
        return profit;
    }
}
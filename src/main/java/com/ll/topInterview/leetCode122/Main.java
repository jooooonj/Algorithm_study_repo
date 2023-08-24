package com.ll.topInterview.leetCode122;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int max = 0;

        for(int i=prices.length-1; i>0; i--){
            int  curr = prices[i];
            max = Math. max(max, curr);

            if(curr < prices[i-1]){
                profit += (max - curr);
                max = 0;
            }
        }
        if(max>0)
            profit += (max - prices[0]);

        return profit;
    }
}

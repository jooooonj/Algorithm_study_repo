package com.ll.programers.level1;

import java.util.Arrays;

public class p135808 {

}

class Solution {
    public int solution(int k, int m, int[] score) {
        //정렬해서 작은거 몰아넣기

        Arrays.sort(score);
        //1,1,1,2,2,3,3

        int sum = 0;
        for(int i=score.length; i>=0; i-=m){
            if(i-m>=0){
                sum += (score[i-m] * m);
            }
        }
        return sum;
    }
}

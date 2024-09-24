package com.ll.programers.level1.p86491;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[][] sizes) {
        int max1 = 0;
        int max2 = 0;

        for(int i=0; i<sizes.length; i++){
            int bigNumber = Math.max(sizes[i][0], sizes[i][1]); //둘중 큰거
            int smallNumber = Math.min(sizes[i][0], sizes[i][1]); //둘중 작은거

            max1 = Math.max(bigNumber, max1); //큰 놈중에 제일 큰 놈
            max2 = Math.max(smallNumber, max2); //작은 놈중에 제일 큰 놈
        }

        return max1 * max2;
    }
}

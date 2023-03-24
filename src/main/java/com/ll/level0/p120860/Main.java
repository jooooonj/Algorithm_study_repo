package com.ll.level0.p120860;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[][] dots) {
        int x = dots[0][0];
        int y = dots[0][1];

        int height = 0;
        int weight = 0;

        for(int i=0; i<4; i++){
            if(x==dots[i][0]){
                height = Math.abs(y-dots[i][1]);
            } else if(y==dots[i][1]){
                weight = Math.abs(x-dots[i][0]);
            }
        }

        return height * weight;
    }
}

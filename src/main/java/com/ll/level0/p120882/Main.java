package com.ll.level0.p120882;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[][] score) {
        int[] avgScore = new int[score.length];
        int[] grade = new int[score.length];
        for(int i=0; i<avgScore.length; i++){
            avgScore[i] = score[i][0] + score[i][1];
        }

        for(int i=0; i<avgScore.length; i++){
            int curr = avgScore[i];
            int count = 0;
            for(int j=0; j<avgScore.length; j++){
                if(curr < avgScore[j])
                    count++;
            }
            grade[i] = count + 1;
        }

        return grade;
    }
}

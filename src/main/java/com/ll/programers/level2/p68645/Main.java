package com.ll.programers.level2.p68645;

public class Main {
}

class Solution {
    public int[] solution(int n) {

        int[][] map = new int[n][n];
        int[] answer = new int[n*(n+1) / 2];

        int number = 1;

        int r = -1;
        int c = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(i%3==0){
                    r++;
                } else if (i%3==1){
                    c++;
                } else {
                    r--;
                    c--;
                }

                map[r][c] = number++;
            }
        }

        int index = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(map[i][j]==0) continue;

                answer[index++] = map[i][j];
            }
        }

        return answer;
    }
}

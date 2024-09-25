package com.ll.programers.level1.p17681;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            answer[i]= "";
        }

        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];

        for(int i=0; i<n; i++){
            int num1 = arr1[i];
            int num2 = arr2[i];

            int j = n - 1;
            while(num1 > 0){
                int value = 0;
                value = num1 % 2;
                num1 /= 2;

                map1[i][j--] = value;
            }

            j = n - 1;
            while(num2 > 0){
                int value = 0;
                value = num2 % 2;
                num2 /= 2;

                map2[i][j--] = value;
            }
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){

                //하나라도 벽이면
                if(map1[i][j] == 1 || map2[i][j] == 1){
                    answer[i] += "#";
                } else {
                    answer[i] += " ";
                }
            }
        }

        return answer;
    }
}

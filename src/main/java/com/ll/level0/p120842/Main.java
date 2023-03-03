package com.ll.level0.p120842;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int r = num_list.length/n;
        int c = n;
        int index = 0;
        int[][] arr = new int[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                arr[i][j] = num_list[index++];
            }
        }

        return arr;
    }
}

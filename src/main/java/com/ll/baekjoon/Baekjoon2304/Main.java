package com.ll.baekjoon.Baekjoon2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int total = 0;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=0; i<N; i++){
            if(max < arr[i][1]){
                max = arr[i][1];
                maxIndex = i;
            }
        }
        total += max;

        int standardX = arr[0][0];
        int standardH = arr[0][1];

        for(int i=0; i<=maxIndex; i++){
            if(arr[i][1] >= standardH){
                total += (arr[i][0] - standardX) * standardH;
                standardX = arr[i][0];
                standardH = arr[i][1];
            }
        }

        standardX = arr[N-1][0];
        standardH = arr[N-1][1];
        for(int i=N-1; i>=maxIndex; i--){
            if(arr[i][1] >= standardH){
                total += (standardX - arr[i][0]) * standardH;
                standardX = arr[i][0];
                standardH = arr[i][1];
            }
        }
        System.out.println(total);




    }
}

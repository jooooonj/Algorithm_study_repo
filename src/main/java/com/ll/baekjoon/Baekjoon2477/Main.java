package com.ll.baekjoon.Baekjoon2477;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //가로 가장 긴 놈 -> 1,2 방향중 제일 큰 놈.
        //세로 가장 긴 놈 -> 3,4 방향중 제일 큰 놈.

        int N = Integer.parseInt(br.readLine());
        int heightMax = 0;
        int weightMax = 0;
        int[][] arr = new int[6][2];
        boolean[] check = new boolean[6];

        for(int i=0; i<6; i++){
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

            if(arr[i][0] == 1 || arr[i][0] == 2){
                weightMax = Math.max(arr[i][1], weightMax);
            }

            if(arr[i][0] == 3 || arr[i][0] == 4){
                heightMax = Math.max(arr[i][1], heightMax);
            }
        }

        int result = heightMax * weightMax;
        int fakeWeight = 0;
        int fakeHeight = 0;
        for(int i=0; i<6; i++){
            int left = i - 1;
            int right = i + 1;

            if(left==-1)
                left = 5;
            if(right==6)
                right = 0;

            if(arr[i][0] == 1 || arr[i][0] == 2){
                if(arr[left][1] != heightMax && arr[right][1] != heightMax)
                    fakeWeight = arr[i][1];
            }

            if(arr[i][0] == 3 || arr[i][0] == 4){
                if(arr[left][1] != weightMax && arr[right][1] != weightMax)
                    fakeHeight = arr[i][1];
            }
        }

        result -= (fakeWeight * fakeHeight);
        System.out.println(result * N);
    }
}

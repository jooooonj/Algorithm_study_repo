package com.ll.baekjoon.Baekjoon15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[] isStart;

    static void calc(int n, int count){
        if(count==N-1)
            return;

        check();
        for(int i=n+1; i<N; i++){
            if(isStart[i] == true)
                continue;
            isStart[i] = true;
            calc(i,count + 1);
            isStart[i] = false;
        }
    }

    static void check(){
        int[] start = new int[N];
        int[] link = new int[N];
        int startIndex = 0;
        int linkIndex = 0;

        for(int i=0; i<N; i++){
            if(isStart[i])
                start[startIndex++] = i;
            else
                link[linkIndex++] = i;
        }

        int startPower = 0;
        int linkPower = 0;
        for(int i=0; i<startIndex -1; i++){
            for(int j=i+1; j<startIndex; j++){
                int r = start[i];
                int c = start[j];
                startPower += map[r][c]+map[c][r];
            }
        }
        for(int i=0; i<linkIndex -1; i++){
            for(int j=i+1; j<linkIndex; j++){
                int r = link[i];
                int c = link[j];
                linkPower += map[r][c]+map[c][r];
            }
        }

        min = Math.min(min, Math.abs(startPower - linkPower));
    }

    //7시 10분까지
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1~N명이 다 들어가야된다.
        //일단싹다 link팀이라고 가정
        //ex) start : 1,2 link : 3,4,5
        //12,21 합 vs 34,43 + 35,53 + 45,54
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isStart = new boolean[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            isStart[i] = true;
            calc(i, 1);
            isStart[i] = false;
        }
        System.out.println(min);
    }
}

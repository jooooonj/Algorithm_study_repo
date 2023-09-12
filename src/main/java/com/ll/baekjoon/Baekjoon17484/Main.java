package com.ll.baekjoon.Baekjoon17484;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static int[] dc = {-1, 0, 1}; //방향은 세 가지가 있음
    static boolean isUsed[] = new boolean[3];
    static int min = Integer.MAX_VALUE;

    static void dfs(int direction, int sum, int r, int c){
        if(r >= N){
            min = Math.min(sum, min);
            return;
        }

        for(int i=0; i<3; i++){
            int nc = c+dc[i];
            if(i==direction) continue; //이미 전에 간 방향이면 건너뛰기
            if(nc<0 || nc >= M) continue;
            dfs(i, sum + map[r][nc], r+1, nc);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            dfs(-1, 0, 0, i);
        }

        System.out.println(min);


    }
}

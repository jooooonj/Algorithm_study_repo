package com.ll.baekjoon.Baekjoon14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int map[][];
    static int MAX = Integer.MIN_VALUE;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                visited[i][j] = true;
                calc(i,j,0,1);
                visited[i][j] = false;

                //교회모양일때 따로 계산
                //현재 i,j
                int sum = 0;

                if(i+1 < N && i-1 >= 0 && j+1 < M){
                    sum = map[i][j] + map[i+1][j] + map[i-1][j] + map[i][j+1];
                    MAX = Math.max(MAX, sum);
                    sum = 0;
                }
                if(i+1 < N && i-1 >= 0 && j-1 >= 0){
                    sum = map[i][j] + map[i+1][j] + map[i-1][j] + map[i][j-1];
                    MAX = Math.max(MAX, sum);
                    sum = 0;
                }
                if(j+1<M && j-1 >=0 && i+1 < N){
                    sum = map[i][j] + map[i][j+1] + map[i][j-1] + map[i+1][j];
                    MAX = Math.max(MAX, sum);
                    sum = 0;
                }
                if(j+1<M && j-1 >=0 && i-1 >= 0){
                    sum = map[i][j] + map[i][j+1] + map[i][j-1] + map[i-1][j];
                    MAX = Math.max(MAX, sum);
                    sum = 0;
                }
            }
        }

        System.out.println(MAX);


    }

    static void calc(int r, int c, int sum, int count){
        if(count>4){
            MAX = Math.max(sum, MAX);
            return;
        }

        if(r<0||c<0||r>=N||c>=M) return;

        if(r+1 < N && !visited[r+1][c]){
            visited[r+1][c] = true;
            calc(r+1,c, sum + map[r][c], count+1);
            visited[r+1][c] = false;
        }

        if(c+1 < M && !visited[r][c+1]){
            visited[r][c+1] = true;
            calc(r,c+1, sum + map[r][c], count+1);
            visited[r][c+1] = false;
        }

        if(r-1 >= 0 && !visited[r-1][c]){
            visited[r-1][c] = true;
            calc(r-1, c, sum+map[r][c], count + 1);
            visited[r-1][c] = false;
        }

        if(c-1 >= 0 && !visited[r][c-1]){
            visited[r][c-1] = true;
            calc(r, c-1, sum+map[r][c], count + 1);
            visited[r][c-1] = false;
        }
    }
}


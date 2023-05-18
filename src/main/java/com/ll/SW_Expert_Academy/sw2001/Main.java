package com.ll.SW_Expert_Academy.sw2001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max;
    static int[][] map;
    static int M;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            max = 0;
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken()); //충격파 범위

            map = new int[N][N];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N-1; i++){
                for(int j=0; j<N-1; j++){
                    find(i,j);
                }
            }

            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }

    static void find(int r, int c){
        if(r+M > N || c+M > N)
            return;

        int sum = 0;

        for(int i=r; i<r+M; i++){
            for(int j=c; j<c+M; j++){
                sum += map[i][j];
            }
        }

        max = Math.max(max, sum);
    }
}

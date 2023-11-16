package com.ll.SW_Expert_Academy.sw1954_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            // 00 01 02 12 22 21 20 10 11
            // 벽에 부딪히거나 값이 존재하면 시계방향으로 턴

            int[] dr = {0, 1, 0, -1};
            int[] dc = {1, 0, -1, 0};

            //0,0부터 시작
            int cr = 0;
            int cc = 0;

            int d = 0; // 첫방향

            for(int i=1; i<=N*N; i++){ //N*N번
                arr[cr][cc] = i;

                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if( nr >= N || nc >= N || nr < 0 || nc < 0 || arr[nr][nc] > 0){
                    d = (d + 1) % 4;

                    cr += dr[d];
                    cc += dc[d];
                } else{
                    cr = nr;
                    cc = nc;
                }
            }

            sb.append("#"+t+"\n" + print(arr, N));
        }

        System.out.println(sb.toString());
    }

    static public String print(int[][] arr, int N){
        String str = "";
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                str += (arr[i][j]+" ");
            }
            str += "\n";
        }

        return str;
    }
}

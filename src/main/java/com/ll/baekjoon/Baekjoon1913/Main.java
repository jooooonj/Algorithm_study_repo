package com.ll.baekjoon.Baekjoon1913;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Main {
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int x = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        int d = 0; //0,1,2,3 순서

        int cr = 0;
        int cc = 0;

        int num = N*N;
        while(true){
            map[cr][cc] = num--;

            if(num < 1)
                break;
            while(true){
                int nr = cr + dr[d%4];
                int nc = cc + dc[d%4];
                if(nr>=0 && nc>=0 && nr<N && nc<N && map[nr][nc]==0){
                    cr = nr;
                    cc = nc;
                    break;
                } else{
                    d += 1;
                }
            }
        }

        int r = 0;
        int c = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==x){
                    r = i+1;
                    c = j+1;
                }
                sb.append(map[i][j]+" ");
            }
            sb.append("\n");
        }
        sb.append(r+" "+c);
        System.out.println(sb);
    }
}

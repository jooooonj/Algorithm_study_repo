package com.ll.baekjoon.Baekjoon10157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int N;
    static boolean[][] visited;

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[R][C];

        N = Integer.parseInt(br.readLine());
        if(N>R*C){
            System.out.println(0);
            System.exit(0);
        }

        int cr = 0;
        int cc = 0;
        int dist = 0; //처음엔 위방향 부딪힐때마다 방향변경

        visited[0][0] = true;
        for(int i=1; i<N; i++){

            int nr = cr + dr[dist];
            int nc = cc + dc[dist];
            if(nr<0 || nc<0 || nr>=R || nc>=C){
                i--;
                dist = (dist+1)%4;
                continue;
            }

            if(visited[nr][nc]){
                i--;
                dist = (dist+1)%4;
                continue;
            }

            visited[nr][nc] = true;
            cr = nr;
            cc = nc;
        }

        System.out.println((cc+1)+" "+(cr+1));
    }
}

package com.ll.E.Elice3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int N;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};
    static class Point{
        int r;
        int c;
        int d;
        Point(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }

    static void dfs(int r, int c, int d, int count){
        if(count==K){
            if(r==N-1 && c==N-1){
                System.out.print("YES");
                System.exit(0);
            } else{
                return;
            }
        }

        int[] nextD = {d, (d+1)%4, (d+3)%4};
        for(int i=0; i<3; i++){
            int nd = nextD[i];
            int nr = r + dr[nd];
            int nc = c + dc[nd];

            if(nr<0||nc<0||nr>=N||nc>=N)continue;
            if(map[nr][nc] == 1) continue;
            if(visited[nr][nc]) continue;

            visited[nr][nc] = true;
            if(nd==d)
                dfs(nr,nc,nd,count);
            else
                dfs(nr,nc,nd,count+1);
            visited[nr][nc] = false;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if(K>0){
            dfs(0,1,0,1);
            dfs(1,0,1,1);
        }
        System.out.print("NO");

    }
}
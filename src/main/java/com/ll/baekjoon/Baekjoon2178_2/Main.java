package com.ll.baekjoon.Baekjoon2178_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[][] map;
    static boolean[][] visited;

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int min = Integer.MAX_VALUE;

    static class Point{
        int r;
        int c;
        int dist;
        Point(int r, int c, int dist){
            this.r=r;
            this.c=c;
            this.dist=dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        bfs(0,0);
        System.out.println(min);
//        for(int r=0; r<N; r++){
//            for(int c=0; c<M; c++){
//                System.out.print(map[r][c]);
//            }
//            System.out.println();
//        }
    }

    static void bfs(int r, int c){
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(r,c,1));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            if(curr.dist >= min) continue;

            int cr = curr.r;
            int cc = curr.c;

            if(cr==N-1 && cc==M-1){
                min = Math.min(min, curr.dist);
            }

            for(int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr<0 || nc<0 || nr>=N || nc>=M) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc]==0) continue;

                q.add(new Point(nr,nc,curr.dist+1));
                visited[nr][nc] = true;
            }
        }
    }
}

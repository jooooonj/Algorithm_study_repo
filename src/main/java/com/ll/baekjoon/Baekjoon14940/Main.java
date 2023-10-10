package com.ll.baekjoon.Baekjoon14940;

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
    static int[][] result;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static class Point{
        int r;
        int c;
        int depth;
        Point(int r, int c, int depth){
            this.r = r;
            this.c = c;
            this.depth = depth;
        }
    }

    static int bfs(int r, int c){
        Queue<Point> q = new LinkedList();
        visited = new boolean[N][M];
        q.add(new Point(r, c, 0));
        visited[r][c] = true;

        while(!q.isEmpty()){
            Point curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;
            result[cr][cc] = curr.depth;

            for(int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr<0 || nc<0 || nr>=N || nc>=M) continue; //범위체크
                if(visited[nr][nc]) continue; //중복방문체크
                if(map[nr][nc] == 0) continue; //갈수없는땅체크

                visited[nr][nc] = true;
                q.add(new Point(nr,nc, curr.depth + 1));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        result = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 2){
                    bfs(i,j);
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(result[i][j] == 0 && map[i][j] != 2 && map[i][j] !=0)
                    sb.append(-1+" ");
                else
                    sb.append(result[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

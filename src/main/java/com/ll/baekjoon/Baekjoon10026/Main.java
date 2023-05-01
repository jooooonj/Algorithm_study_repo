package com.ll.baekjoon.Baekjoon10026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N;
    static char[][] map;
    static char[][] map2;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static boolean[][] normalVisited;
    static boolean[][] notNormalVisited;
    static Queue<Point> q = new LinkedList<>();

    static class Point {
        int r;
        int c;
        char value;

        Point(int r, int c, char value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }
    }

    static void notNormal(int r, int c) {

        q.add(new Point(r,c, map2[r][c]));
        notNormalVisited[r][c] = true;

        while (!q.isEmpty()) {

            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (notNormalVisited[nr][nc]) continue;
                if (map2[nr][nc] != curr.value) continue;
                q.add(new Point(nr, nc, curr.value));
                notNormalVisited[nr][nc] = true;
            }
        }
    }

    static void normal(int r, int c) {

        q.add(new Point(r,c, map[r][c]));
        normalVisited[r][c] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();

            for (int i = 0; i < 4; i++) {
                int nr = curr.r + dr[i];
                int nc = curr.c + dc[i];

                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (normalVisited[nr][nc]) continue;
                if (map[nr][nc] != curr.value) continue;
                q.add(new Point(nr, nc, curr.value));
                normalVisited[nr][nc] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        map2 = new char[N][N];
        normalVisited = new boolean[N][N];
        notNormalVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);

                if(str.charAt(j)=='G'){
                    map2[i][j] = 'R';
                } else
                    map2[i][j] = str.charAt(j);
            }
        }
        int normalCount = 0;
        int notNormalCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!normalVisited[i][j]) {
                    normal(i,j);
                    normalCount++;
                }

                if(!notNormalVisited[i][j]){
                    notNormal(i,j);
                    notNormalCount++;
                }
            }
        }
        System.out.print(normalCount+" "+notNormalCount);
    }

    private static void print() {
        for(int i=0; i<N; i++){
            for(int j=0;j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void print2(){
        for(int i=0; i<N; i++){
            for(int j=0;j<N; j++){
                System.out.print(notNormalVisited[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}


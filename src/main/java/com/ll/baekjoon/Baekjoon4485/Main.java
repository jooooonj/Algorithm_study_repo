package com.ll.baekjoon.Baekjoon4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dc = {1,-1,0,0};
    static int[] dr = {0,0,-1,1};
    static int[][] map;
    static int[][] note;
    static class Point implements Comparable<Point>{
        int r;
        int c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }

        public int compareTo(Point o){
            return map[r][c] - map[o.r][o.c];
        }
    }
    static void function(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0));

        while (!pq.isEmpty()) {
            Point curr = pq.poll();
            int cr = curr.r;
            int cc = curr.c;

            for(int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(nr<0||nc<0||nr>=N||nc>=N)continue;
                if(note[nr][nc] > note[cr][cc] + map[nr][nc]){
                    note[nr][nc] = note[cr][cc] + map[nr][nc];
                    pq.add(new Point(nr,nc));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true){
            int num = 1;
            N = Integer.parseInt(br.readLine());
            if(N==0)
                System.exit(0);
            map = new int[N][N];
            note = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    note[i][j] = Integer.MAX_VALUE;
                }
            }

            note[0][0] = map[0][0];
            function();
            System.out.println("Problem "+num+": "+note[N-1][N -1]);
            num++;
        }
    }
}

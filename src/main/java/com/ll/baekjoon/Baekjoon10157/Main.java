package com.ll.baekjoon.Baekjoon10157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R;
    static int C;
    static int K;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static boolean[][] visited;
    static int[][] map;

    static int[] allocate(int r, int c, int depth, int d){
        if(depth==K)
            return new int[]{r+1,c+1};
        if(depth==R*C)
            return null;
        visited[r][c] = true;
        map[r][c] = depth;

        int nd = d;
        int nr = r+dr[d];
        int nc = c+dc[d];
        if(nr>=0 && nc>=0 && nr<R && nc<C){
            if(visited[nr][nc]){
                nd = (d+1) % 4;
                nr = r+dr[nd];
                nc = c+dc[nd];
            }
        } else{
            nd = (d+1) % 4;
            nr = r+dr[nd];
            nc = c+dc[nd];
        }

        return allocate(nr,nc,depth+1,nd);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken()); //7
        R = Integer.parseInt(st.nextToken()); //6
        visited = new boolean[R][C];
        map = new int[R][C];
        K = Integer.parseInt(br.readLine());

        int[] result = allocate(0, 0, 1, 0);


        if (result == null) {
            System.out.println(0);
        } else{
            System.out.println(result[1]+" "+result[0]);
        }

    }
}

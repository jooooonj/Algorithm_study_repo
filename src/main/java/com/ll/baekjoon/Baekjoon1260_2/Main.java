package com.ll.baekjoon.Baekjoon1260_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int start;
    static int[][] map;
    static boolean[]visited1;
    static boolean[] visited2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        visited1 = new boolean[N+1];
        visited2 = new boolean[N+1];

        M = Integer.parseInt(st.nextToken());

        start = Integer.parseInt(st.nextToken());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        dfs(start);
        System.out.println();
        bfs(start);
    }

    static public void bfs(int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);

        visited1[node] = true; //다녀감 ~

        while(!q.isEmpty()){
            int curr = q.poll();
            System.out.print(curr+" ");

            for(int i=1; i<=N; i++){
                if(!visited1[i] && map[curr][i]==1){
                    q.add(i);
                    visited1[i] = true;
                }
            }
        }
    }

    static public void dfs(int node){
        visited2[node] = true;
        System.out.print(node+" ");

        for(int i=1; i<=N; i++){
            if(!visited2[i] && map[node][i]==1){
                dfs(i);
            }
        }
    }
}

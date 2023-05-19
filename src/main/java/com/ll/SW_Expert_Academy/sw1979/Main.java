package com.ll.SW_Expert_Academy.sw1979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[][] map;
    static int result;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            result = 0;
            
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] == 1){
                        result += check(i,j);
                    }
                }
            }

            sb.append("#" + t + " " + result + "\n");
        }
        System.out.println(sb);
    }

    static int check(int r, int c){
        int count = 0;
        int weight = 0;
        int height = 0;
        int i = r;
        int j = c;

        while(map[r][j] == 1){
            visited[r][j] = true;
            weight++;
            j++;

            if(j>=N)break;
        }

        while(map[i][c] == 1){
            visited[i][cf
            i++;

            if(i>=N || j>=N)break;
        }

        if(weight == K) count++;
        if(height == K) count++;
        return  count;
    }
}

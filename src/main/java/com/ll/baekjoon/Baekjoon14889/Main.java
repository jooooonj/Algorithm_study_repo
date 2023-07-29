package com.ll.baekjoon.Baekjoon14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[] isStartTeam;

    static void dfs(int num, int depth){
        if(depth == N/2) {
            calc();
            return;
        }

        for(int i=num; i<N; i++){
            isStartTeam[i] = true;
            dfs(i+1, depth+1);
            isStartTeam[i] = false;
        }
    }

    static void calc(){
        int[] startTeam = new int[N];
        int[] linkTeam = new int[N];
        int start = 0;
        int link = 0;
        for(int i=0; i<N; i++){
            if(isStartTeam[i])
                startTeam[start++] = i;
            else
                linkTeam[link++] = i;
        }

        int startScore = 0;
        int linkScore = 0;
        for(int i=0; i<start-1; i++){
            for(int j=i+1; j<start; j++){
                int a = startTeam[i];
                int b = startTeam[j];
                startScore += (map[a][b]+map[b][a]);
            }
        }

        for(int i=0; i<link-1; i++){
            for(int j=i+1; j<link; j++){
                int a = linkTeam[i];
                int b = linkTeam[j];
                linkScore += (map[a][b]+map[b][a]);
            }
        }

        min = Math.min(min, Math.abs(startScore - linkScore));
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        isStartTeam = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);

        System.out.println(min);



//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(map[i][j] +" ");
//            }
//            System.out.println();
//        }

    }
}

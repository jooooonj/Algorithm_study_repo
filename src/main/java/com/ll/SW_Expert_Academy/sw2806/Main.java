package com.ll.SW_Expert_Academy.sw2806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count; //경우의수
    static int[] map;
    static boolean[] visited1; //세로 방문 배열
    static boolean[] visited2; //r+c 대각 방문 배열
    static boolean[] visited3; // |r-c| 대각 방문 배열
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            N = Integer.parseInt(br.readLine());
            count = 0;
            map = new int[N];
            visited1 = new boolean[N];
            visited2 = new boolean[N*2 - 1];
            visited3 = new boolean[N*2 - 1];

            dfs(0);
            sb.append("#"+t+" "+count+"\n");
        }
        System.out.println(sb);
    }
    static void dfs(int n){
        if(n>=N){
            count++;
            return;
        } else{

            for(int i=0; i<N; i++){
                if(visited1[i] || visited2[n+i] || visited3[(n-i) + (N-1)])
                    continue;

                map[n] = i;
                visited1[i] = true;
                visited2[n+i] = true;
                visited3[(n-i) + (N-1)] = true;

                dfs(n+1);

                visited1[i] = false;
                visited2[n+i] = false;
                visited3[(n-i) + (N-1)] = false;
            }
        }
    }
}

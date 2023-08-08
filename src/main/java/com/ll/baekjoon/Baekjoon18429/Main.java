package com.ll.baekjoon.Baekjoon18429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; //N일동안
    static int K; //K씩 근손실
    static int[] kit;
    static boolean[] visited;
    static int count = 0;

    static void dfs(int depth, int power){
        if(depth == N){
            count++; //경우의 수 증가
            return;
        }

        //매일 K씩 감소
        power -= K;

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            if(500 > power + kit[i])continue;
            visited[i] = true;
            dfs(depth+1, power + kit[i]);
            visited[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kit = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        //키트에 저장
        for(int i=0; i<N; i++){
            kit[i] = Integer.parseInt(st.nextToken());
        }

        //키트 순서 (조합론 순서 o 중복 x)
        dfs(0, 500);
        System.out.println(count);
    }
}

package com.ll.baekjoon.Baekjoon1535;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] visited;
    static int[] L; //stamina
    static int[] J; //happy
    static int result = 0;
    static void dfs(int num, int depth, int stamina, int happy){
        if(depth > N || stamina <= 0)
            return;

        result = Math.max(result, happy);

        for(int i=num+1; i<N; i++){
            dfs(i, depth+1, stamina - L[i], happy + J[i]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        L = new int[N];
        J = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            J[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<N; i++){
            dfs(i, 1, 100-L[i], J[i]);
        }

        System.out.println(result);
    }
}

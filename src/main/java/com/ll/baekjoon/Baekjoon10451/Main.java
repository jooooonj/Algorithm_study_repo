package com.ll.baekjoon.Baekjoon10451;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int count;
    static int[] arr;
    static void dfs(int node){
        if(visited[node]){
            count++;
            return;
        } else {
            visited[node] = true;
            dfs(arr[node]);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            count = 0;
            int n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<n; i++){
                arr[i + 1] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++){
                if(!visited[i]){
                    dfs(i);
                }
            }

            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}

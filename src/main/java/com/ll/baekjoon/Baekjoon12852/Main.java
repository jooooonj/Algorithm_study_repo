package com.ll.baekjoon.Baekjoon12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;
    static int[] node;
    static String result = "";
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        node = new int[n+1];
        dp[1] = 0;
        for(int i=2; i<=n; i++){
            dp[i] = dp[i-1] + 1;
            node[i] = i-1;
            if(i%2==0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2] + 1;
                node[i] = i/2;
            }

            if(i%3==0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3] + 1;
                node[i] = i/3;
            }
        }


        int index = n;
        sb.append(dp[n]+"\n");
        sb.append(n+" ");
        for(int i=0; i<dp[n]; i++){
            sb.append(node[index]+" ");
            index = node[index];
        }
        System.out.println(sb);
    }
}

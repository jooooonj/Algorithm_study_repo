package com.ll.baekjoon.R_Baekjoon15989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        int[][] dp = new int[10001][4]; //1~3
        dp[1][1] = 1; //1
        dp[2][1] = 1; //1 1
        dp[2][2] = 1; //2
        dp[3][1] = 1; //1 1 1
        dp[3][2] = 1; //2 1
        dp[3][3] = 1; //3

//        dp[4][1] = dp[3][1]; 1111 211 31
//        dp[4][2] = dp[2][1] + dp[2][2]; 22
//        dp[4][3] = dp[1][1] + dp[1][2] + dp[1][3];
        
        for(int i=4; i<dp.length; i++){
            dp[i][1] = dp[i-1][1];
            dp[i][2] = dp[i-2][1] + dp[i-2][2];
            dp[i][3] = dp[i-3][1] + dp[i-3][2] + dp[i-3][3];
        }
        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1] + dp[n][2] + dp[n][3] + "\n");
        }
        System.out.println(sb);
    }
}

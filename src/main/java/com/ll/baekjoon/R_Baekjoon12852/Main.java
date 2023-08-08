package com.ll.baekjoon.R_Baekjoon12852;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dp;
    static int[] history;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        dp = new int[N+1]; //count 세기
        history = new int[N+1];
        history[0] = 1;
        for(int i=2; i<=N; i++){
            dp[i] =  dp[i-1] + 1;
            history[i] = i -1;

            if(i%2==0 && dp[i] > dp[i/2] + 1){
                dp[i] = dp[i/2] + 1;
                history[i] = i/2;
            }

            if(i%3==0 && dp[i] > dp[i/3] + 1){
                dp[i] = dp[i/3] + 1;
                history[i] = i/3;
            }
        }

        sb.append(dp[N]+"\n"); //최소 count

        int num = N;
        while(num >= 1){
            sb.append(num+" ");
            num = history[num];
        }
        System.out.println(sb);





    }
}

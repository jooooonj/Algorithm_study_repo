package com.ll.baekjoon.Baekjoon2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2293
 * 백준 2293
 * 문제풀이 : dp
 */
public class Main {
    static int[] dp;
    static int[] arr;
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        arr = new int[n];
        dp = new int[k+1];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1;

        for(int i=0; i<n; i++) {
            for(int j=arr[i]; j<k+1; j++) {
                dp[j] = dp[j]+dp[j-arr[i]];
            }
        }

        System.out.println(dp[k]);

    }
}

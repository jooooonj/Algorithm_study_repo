package com.ll.baekjoon.Baekjoon18110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] comments = new int[n];

        for(int i=0; i<n; i++){
            comments[i] = Integer.parseInt(br.readLine());
        }

        //일단 정렬
        Arrays.sort(comments);

        //30% 질사평균
        int exclude = (int) Math.round(n * 0.15);
        double sum = 0;
        for(int i = exclude; i< n-exclude; i++){
            sum += comments[i];
        }
        int result = (int)Math.round(sum / (n-exclude*2));
        System.out.println(result);
    }
}

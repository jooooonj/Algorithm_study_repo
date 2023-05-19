package com.ll.SW_Expert_Academy.sw1983;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String[] sc = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int th = Integer.parseInt(st.nextToken());
            int[] score = new int[n];
            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                score[i] = Integer.parseInt(st.nextToken()) * 35 +
                        Integer.parseInt(st.nextToken()) * 45 +
                        Integer.parseInt(st.nextToken()) * 20;
            }

            int count = 0;
            for(int i=0; i<n; i++){
                if(score[th-1] < score[i])
                    count++;
            }

            sb.append("#"+t+" "+sc[count / (n/10)]+"\n");
        }
        System.out.println(sb);
    }
}

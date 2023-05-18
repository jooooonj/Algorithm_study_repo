package com.ll.SW_Expert_Academy.sw1204;

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

        for(int t=1; t<=T; t++){
            int tc = Integer.parseInt(br.readLine());
            int result = -1;
            int max = -1;

            int[] score = new int[101];
            st = new StringTokenizer(br.readLine());

            for(int i=0; i<1000; i++){
                score[Integer.parseInt(st.nextToken())]++;
            }

            for(int i=0; i<101; i++) {
                if (max <= score[i]) {
                    max = score[i];
                    result = i;
                }
            }

            sb.append("#"+tc+" "+result+"\n");
        }
        System.out.println(sb);
    }
}

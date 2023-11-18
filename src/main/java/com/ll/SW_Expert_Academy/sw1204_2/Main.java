package com.ll.SW_Expert_Academy.sw1204_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            t = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] score = new int[101];

            for(int i=0; i<1000; i++){
                Integer sc = Integer.parseInt(st.nextToken());
                score[sc]++;
            }

            int maxIndex = -1;
            int max = -1;
            for(int i=0; i<score.length; i++){
                if(max <= score[i]){
                    maxIndex = i;
                    max = score[i];
                }
            }

            sb.append("#" + t + " " + maxIndex+"\n");
        }

        System.out.println(sb.toString());
    }
}

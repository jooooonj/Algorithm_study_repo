package com.ll.baekjoon.Baekjoon10431;

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
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int[] students = new int[20];
            for(int i=0; i<20; i++){
                students[i] = Integer.parseInt(st.nextToken());
            }

            int step = 0;
            for(int i=19; i>0; i--){

                for(int j=0; j<i; j++){
                    if(students[i] < students[j]){
                        step++;
                    }
                }
            }
            sb.append(t+" "+step+"\n");

        }
        System.out.println(sb);
    }
}

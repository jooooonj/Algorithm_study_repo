package com.ll.baekjoon.Baekjoon19637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] names = new String[N];
        int[] powers = new int[N];
        int[] people = new int[M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            names[i] = st.nextToken();
            powers[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++){
            int power = Integer.parseInt(br.readLine());

            int left = 0;
            int right = N-1;

            while(left<=right){
                int m = (left + right) / 2;

                if(power > powers[m]) left = m+1;
                if(power <= powers[m]) right = m-1;
            }

            sb.append(names[left] + "\n");
        }
        System.out.println(sb);
    }
}

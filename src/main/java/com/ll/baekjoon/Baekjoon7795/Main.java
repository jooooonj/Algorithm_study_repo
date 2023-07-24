package com.ll.baekjoon.Baekjoon7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] A = new int[N];

            int M = Integer.parseInt(st.nextToken());
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(B);
            Arrays.sort(A);
            int count = 0;
            for(int i=0; i<N; i++){
                int s = 0;
                int e = M-1;
                while(s<=e){
                    int m = (s+e)/2;
                    if(B[m] < A[i])
                        s = m+1;
                    else
                        e = m-1;
                }
                count += s;
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
}

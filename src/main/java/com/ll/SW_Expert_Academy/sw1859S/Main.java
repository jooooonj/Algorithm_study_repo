package com.ll.SW_Expert_Academy.sw1859S;

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

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] tmp = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
            }
            int max = 0;
            long sum = 0;

            for(int i=arr.length-1; i>=0; i--){
                max = Math.max(max, arr[i]);

                if(max > arr[i]){
                    sum += (max - arr[i]);
                }
            }

            sb.append("#" + t + " " + sum + "\n");
        }
        System.out.println(sb);
    }
}



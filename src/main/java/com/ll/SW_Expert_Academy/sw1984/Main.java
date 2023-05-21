package com.ll.SW_Expert_Academy.sw1984;

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

        for(int t=1; t<=T; t++){
            int[] arr = new int[10];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<10; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            int sum = 0;
            for(int i=1; i<9; i++){
                sum += arr[i];
            }

            double avg = sum / 8.0;
            long result = Math.round(avg);

            sb.append("#" + t + " " + result + "\n");
        }
        System.out.println(sb);
    }
}

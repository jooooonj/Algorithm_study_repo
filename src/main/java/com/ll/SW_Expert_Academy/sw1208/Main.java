package com.ll.SW_Expert_Academy.sw1208;

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

        int T = 10;
        for(int t=1; t<=T; t++){
            int result = 0;
            int limit = Integer.parseInt(br.readLine());

            int[] arr = new int[100];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<100; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<limit; i++){
                Arrays.sort(arr);
                result = arr[arr.length - 1] - arr[0];
                if(result <= 1) break;

                arr[arr.length - 1]--; //제일 높은놈이
                arr[0]++; //제일 낮은거 하나 줘
            }

            Arrays.sort(arr);
            result = arr[arr.length - 1] - arr[0];

            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb);
    }
}

package com.ll.SW_Expert_Academy.sw2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int result = 0;

            int N = Integer.parseInt(br.readLine());
            int mid = N / 2;

            int extend = 0;
            for(int i=0; i<=mid; i++){
                String str = br.readLine();

                for(int j=mid-extend; j<=mid+extend; j++){
                    result += str.charAt(j) - '0';
                }
                extend++;
            }

            extend-= 2;

            for(int i=mid+1; i<N; i++){
                String str = br.readLine();
                for(int j=mid-extend; j<=mid+extend; j++){
                    result += str.charAt(j) - '0';
                }
                extend--;
            }

            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb);
    }
}



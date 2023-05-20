package com.ll.SW_Expert_Academy.sw1986;

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
            int n = Integer.parseInt(br.readLine());

            int sum = 0;

            for(int i=1; i<=n; i++){
                if(i%2==0)
                    sum -= i;
                else
                    sum += i;
            }

            sb.append("#"+t+" "+sum+"\n");
        }
        System.out.println(sb);
    }
}

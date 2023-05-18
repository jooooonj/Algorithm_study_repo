package com.ll.SW_Expert_Academy.sw2072;

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
            int result = 0;

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<10; i++){
                int num = Integer.parseInt(st.nextToken());
                if(num%2!=0) result+=num;
            }

            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb);
    }
}

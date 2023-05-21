package com.ll.SW_Expert_Academy.sw1976;

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

            int s = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            s += Integer.parseInt(st.nextToken());
            m += Integer.parseInt(st.nextToken());

            if(m>=60){
                s += 1;
                m -= 60;
            }

            if(s>12){
                s -= 12;
            }

            sb.append("#" + t + " " + s + " " + m + "\n");
        }
        System.out.println(sb);
    }
}

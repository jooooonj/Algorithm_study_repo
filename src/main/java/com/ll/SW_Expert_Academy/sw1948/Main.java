package com.ll.SW_Expert_Academy.sw1948;

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
            int[] day = {0,31,28,31,30,31,30,31,31,30,31,30,31};

            st = new StringTokenizer(br.readLine());
            int month = Integer.parseInt(st.nextToken());
            int date = Integer.parseInt(st.nextToken());
            for(int i=1; i<month; i++){
                date += day[i];
            }

            int toMonth = Integer.parseInt(st.nextToken());
            int toDate = Integer.parseInt(st.nextToken());
            for(int i=1; i<toMonth; i++){
                toDate += day[i];
            }

            int result = toDate - date + 1;

            sb.append("#" + t + " " + result + "\n");
        }
        System.out.println(sb);
    }
}


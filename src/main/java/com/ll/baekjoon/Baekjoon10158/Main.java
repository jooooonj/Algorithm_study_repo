package com.ll.baekjoon.Baekjoon10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        // r마주치면 (r * -1) c마주치면 (c * -1)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());

//       시간초과 코드
//        int dr = 1;
//        int dc = 1;
//        for(int i=0; i<n; i++){
//            c += dc;
//            r += dr;
//            if(r==0 || r==R) dr *= -1;
//            if(c==0 || c==C) dc *= -1;
//        }

        //이해가 안감
        System.out.print(c+" "+r);
    }
}

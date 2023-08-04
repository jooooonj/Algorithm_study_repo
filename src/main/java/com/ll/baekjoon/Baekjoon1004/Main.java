package com.ll.baekjoon.Baekjoon1004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static boolean calc(int x1, int y1, int x2, int y2, int d){
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2)) < d;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int r1 = Integer.parseInt(st.nextToken());
            int c1 = Integer.parseInt(st.nextToken());

            int r2 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());


            int count = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());

                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int d = Integer.parseInt(st.nextToken());

                boolean check1 = calc(r1,c1,r,c,d);
                boolean check2 = calc(r2,c2,r,c,d);

                if( (!check1 && check2) || (
                        !check2 && check1))
                    count++;
            }
            sb.append(count + "\n");
        }
        System.out.print(sb);
    }

}

package com.ll.SW_Expert_Academy.sw2805_2;

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

            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            int limit = N / 2;
            int sum = 0;
            for (int i = 0; i < N; i++){
                sum += map[limit][i];
            }

            int count = 0;
            for (int i = 0; i < limit; i++) {

                for (int j = limit - i; j <= limit + i; j++) {
                    sum += map[i][j];
                }
            }

            for (int i = N - 1; i > limit; i--) {

                for (int j = limit - count ; j <= limit + count; j++) {
                    sum += map[i][j];
                }
                count++;
            }

            sb.append("#" + t + " " + sum + "\n");
        }

        System.out.println(sb.toString());
    }
}

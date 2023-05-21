package com.ll.SW_Expert_Academy.sw1209;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T=10;
        for(int t=1; t<=T; t++){
            map = new int[100][100];

            max = Integer.MIN_VALUE;
            t = Integer.parseInt(br.readLine());

            for(int i=0; i<100; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<100; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            //가로
            for(int i=0; i<100; i++) {
                int weight = 0;
                for(int j=0; j<100; j++){
                    weight += map[i][j];
                }
                max = Math.max(weight, max);
            }

            //세로
            for (int j = 0; j < 100; j++) {
                int height = 0;
                for (int i = 0; i < 100; i++) {
                    height += map[i][j];
                }
                max = Math.max(height, max);
            }

            //대각선 1
            int value1 = 0;
            for(int i=0; i<100; i++){
                value1 += map[i][i];
            }
            max = Math.max(value1, max);

            int value2 = 0;
            for(int i=99; i>=0; i--){
                value2 += map[i][99-i];
            }
            max = Math.max(value2, max);

            sb.append("#" + t + " " + max + "\n");
        }
        System.out.println(sb);
    }
}

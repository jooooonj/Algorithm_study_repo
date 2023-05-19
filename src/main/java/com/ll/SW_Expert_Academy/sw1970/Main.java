package com.ll.SW_Expert_Academy.sw1970;

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
            int[][] money = new int[8][2];

            money[0][0] = 50000;
            money[1][0] = 10000;
            money[2][0] = 5000;
            money[3][0] = 1000;
            money[4][0] = 500;
            money[5][0] = 100;
            money[6][0] = 50;
            money[7][0] = 10;


            for (int i = 0; i < money.length; i++) {
                if (money[i][0] <= N) {
                    money[i][1] = N / money[i][0];
                    N -= N / money[i][0] * money[i][0];
                }
            }
            sb.append("#" + t+"\n");

            for(int i=0; i<money.length; i++){
                sb.append(money[i][1]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}


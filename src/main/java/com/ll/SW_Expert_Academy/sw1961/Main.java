package com.ll.SW_Expert_Academy.sw1961;

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

            int[][] arr = new int[n][n];

            for(int i=0; i<n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            sb.append("#"+t+"\n");
            //90도
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                      sb.append(arr[n-1-j][i]);
                }
                sb.append(" ");
                for(int j=0; j<n; j++){
                    sb.append(arr[n-1-i][n-1-j]);
                }
                sb.append(" ");

                for(int j=0; j<n; j++){
                    sb.append(arr[j][n-1-i]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}

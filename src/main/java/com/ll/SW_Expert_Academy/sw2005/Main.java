package com.ll.SW_Expert_Academy.sw2005;

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
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            for(int i=0; i<arr.length; i++){
                arr[i][0] = 1;
            }

            for(int i=1; i<arr.length; i++){
                for(int j=1; j<arr.length; j++){
                    arr[j][i] = arr[j-1][i-1] + arr[j-1][i];
                }
            }

            sb.append("#"+t+"\n");

            for(int i=0; i<arr.length; i++){
                for(int j=0; j<arr.length; j++){
                    if(arr[i][j]!=0){
                        sb.append(arr[i][j]+" ");
                    }
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}

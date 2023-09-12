package com.ll.baekjoon.Baekjoon2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int[] seq = new int[N*N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int index = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                seq[index++] = map[i][j];
            }
        }
        Arrays.sort(seq);

        System.out.println(seq[N*N - N ]);
    }
}

package com.ll.SW_Expert_Academy.sw1206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 10;
        int N;
        //테케 10개
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[][] building = new int[256][N];
            for(int i=0; i<N; i++){
                int floor = Integer.parseInt(st.nextToken());
                for(int j=0; j<floor; j++){
                    building[j][i] = 1;
                }
            }

            int count = 0;
            for(int i=0; i<256; i++){
                for(int j=2; j<N-2; j++){
                    if (building[i][j] == 0) {
                        continue;
                    }

                    if(building[i][j-1] == 0 && building[i][j-2] == 0
                    && building[i][j+1] == 0 && building[i][j+2] == 0)
                        count++;
                }
            }

            sb.append("#"+(t+1) + " " + count + "\n");
        }
        System.out.println(sb);
    }
}


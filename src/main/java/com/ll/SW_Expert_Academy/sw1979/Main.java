package com.ll.SW_Expert_Academy.sw1979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static int[][] map;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            result = 0;

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N+2][N+2];

            for (int i = 1; i <= N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            for(int i=1; i<=N; i++){
                int count = 0;
                for(int j=1; j<=N; j++){
                    if(map[i][j-1] == 0 && map[i][j] == 1)
                        count = 1;
                    else if(map[i][j-1]==1 && map[i][j]==1)
                        count += 1;
                    else if(map[i][j] == 0)
                        count = 0;

                    if(count==K && map[i][j+1]==0)
                        result++;
                }
            }

            for(int i=1; i<=N; i++){
                int count = 0;
                for(int j=1; j<=N; j++){
                    if(map[j-1][i] == 0 && map[j][i] == 1)
                        count = 1;
                    else if(map[j-1][i]==1 && map[j][i]==1)
                        count++;
                    else
                        count = 0;

                    if(count==K && map[j+1][i]==0)
                        result++;
                }
            }

            sb.append("#" + t + " " + result + "\n");
        }
        System.out.println(sb);
    }
}

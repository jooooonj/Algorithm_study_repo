package com.ll.baekjoon.Baekjoon15684S;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int H;
    static int MIN = Integer.MAX_VALUE;
    static int[][] link;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로선
        M = Integer.parseInt(st.nextToken()); //가로선
        H = Integer.parseInt(st.nextToken()); //세로선마다 가로선을 놓을 수 있는 위치의 개수

        link = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int seq = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());

            link[seq][line] = 1; //line과 line+1이 seq번째 줄에서 연결됨.
        }

        bfs(0,1,1);
        MIN = MIN == Integer.MAX_VALUE ? -1 : MIN;
        System.out.println(MIN);
    }

    static void bfs(int count, int seq, int line){
        if(success())
            MIN = Math.min(MIN, count);

        if(count>=3) return;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=H; j++){
                if(link[j][i] == 1) continue;
                if(link[j][i-1] == 1) continue;
                if(i>=N)continue;
                link[j][i] = 1;
                bfs(count + 1, j, i);
                link[j][i] = 0;
            }
        }
    }

    static boolean success() {
        for (int i = 1; i <= N; i++) {
            int line = i;
            int seq = 1;
            while (seq <= H) {
                if(link[seq][line] == 1){
                    line++; seq++;
                } else if(link[seq][line-1] == 1){
                    line--; seq++;
                } else
                    seq++;
            }

            if(line!=i) return false;
        }
        return true;
    }
}

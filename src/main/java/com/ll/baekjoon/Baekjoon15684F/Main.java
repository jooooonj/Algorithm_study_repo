package com.ll.baekjoon.Baekjoon15684F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int H;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //세로선
        M = Integer.parseInt(st.nextToken()); //가로선
        H = Integer.parseInt(st.nextToken()); //세로선마다 가로선을 놓을 수 있는 위치의 개수

        int[][] link = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int seq = Integer.parseInt(st.nextToken());
            int line = Integer.parseInt(st.nextToken());

            link[seq][line] = 1; //line과 line+1이 seq번째 줄에서 연결됨.
        }

        bfs(link, 0);

        if (MIN == Integer.MAX_VALUE) System.out.println(-1);
        else
            System.out.println(MIN);


    }

    static int move(int line, int seq, int[][] link) {
        System.out.println(line+", "+seq);

        if (seq > H) {
            System.out.println(line);
            return line;
        }


        if (link[seq][line] == 1) {
            return move(line + 1, seq + 1, link);
        } else if (link[seq][line - 1] == 1) {
            return move(line - 1, seq + 1, link);
        } else {
            return move(line, seq + 1, link);
        }


    }

    static boolean check(int[][] link) {
        for (int i = 1; i <= N; i++) {
            if (move(1, i, link) != i) //i가 i가 안나오면 false 리턴
                return false;
        }

        return true;
    }

    static void bfs(int[][] link, int count) {
        if (check(link)) {
            MIN = Math.min(MIN, count);
            return;
        }

        if (count > 3 || MIN <= count)
            return;

        for (int i = 1; i < N; i++) { //세로선
            for (int j = 1; j <= H; j++) { //가로선

                if (link[j][i] == 1) continue; //다음으로 가는 다리 있는지
                if (link[j][i-1] == 1) continue; //이전으로 가는 다리 있는지
                if (link[j][i+1] == 1) continue; //연속되는지

                link[j][i] = 1;

                bfs(link, count + 1);

                link[j][i] = 0;
            }
        }
    }

}


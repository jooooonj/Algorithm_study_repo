package com.ll.SW_Expert_Academy.Baekjoon14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] row = new int[4]; //북 -> 남
    static int[] col = new int[4]; //서 -> 동
    static int N; //지도 세로크기
    static int M; //지도 가로크기
    static int cr; //시작위치 r
    static int cc; //시작위치 c
    static int K; //명령어 개수
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //이동한 칸에 쓰여 있는 수가 0이면,
        // 주사위의 바닥면에 쓰여 있는 수가 칸에 복사된다.
        //
        // 0이 아닌 경우에는
        // 칸에 쓰여 있는 수가 주사위의 바닥면으로 복사되며,
        // 칸에 쓰여 있는 수는 0이 된다.

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        cr = Integer.parseInt(st.nextToken());
        cc = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //지도 그리기
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = new int[7]; //주사위


        //동쪽은 1, 서쪽은 2, 북쪽은 3, 남쪽은 4
        //현재 위치 (sr, sc)
        st = new StringTokenizer(br.readLine());
        //명령어 시작
        for (int k = 0; k < K; k++) {
            int cmd = Integer.parseInt(st.nextToken());
            int nr = cr;
            int nc = cc;
            //동서남북 방향에 따른 좌표 변화, 주사위 변화
            if (cmd == 1) {
                nc += 1;
            }
            if (cmd == 2) {
                nc -= 1;
            }
            if (cmd == 3) {
                nr -= 1;
            }
            if (cmd == 4) {
                nr += 1;
            }

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

            move(dice, cmd);
            cr = nr;
            cc = nc;

            System.out.println(dice[2]);

            if(map[cr][cc] == 0){
                map[cr][cc] = dice[5];
            } else{
                dice[5] = map[cr][cc];
                map[cr][cc] = 0;
            }
        }
    }

    static void move(int[] dice, int direction) {
        if (direction == 1) {
            int tmp = dice[2];
            dice[2] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[3];
            dice[3] = tmp;
        } else if (direction == 4) {
            int tmp = dice[2];
            dice[2] = dice[6];
            dice[6] = dice[5];
            dice[5] = dice[1];
            dice[1] = tmp;
        } else if (direction == 3) {
            int tmp = dice[6];
            dice[6] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[5];
            dice[5] = tmp;
        } else if (direction == 2) {
            int tmp = dice[2];
            dice[2] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[4];
            dice[4] = tmp;
        }
    }
}


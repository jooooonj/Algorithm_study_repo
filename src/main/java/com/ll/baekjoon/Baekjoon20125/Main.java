package com.ll.baekjoon.Baekjoon20125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        //가장 첫번째 나온게 머리 (그 아래는 심장)

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        char[][] map = new char[N][N];

        boolean head = false;
        int hr = -1;
        int hc = -1;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
                if (!head && map[i][j] == '*') {
                    hr = i;
                    hc = j;
                    head = true;
                }
            }
        }

        //심장
        int cr = hr + 1; //머리 한칸 아래
        int cc = hc;

        //왼팔
        int lcount = 0;
        int l = cc - 1;
        while (l>=0 && map[cr][l] == '*') {
            ++lcount;
            l--;
        }

        //오른팔
        int rcount = 0;
        int r = cc + 1;
        while (r<N && map[cr][r] == '*') {
            ++rcount;
            r++;
        }

        //허리
        int m = cr + 1;
        int mcount = 0;
        while (m<N && map[m][cc] == '*') {
            ++mcount;
            m++;
        }
        //허리 끝부분 -> m-1, cc

        //왼쪽 다리
        int llr = m;
        int llc = cc - 1;
        int llcount = 0;
        while (llr<N && map[llr][llc] == '*') {
            ++llcount;
            llr++;
        }

        //우측 다리
        int rlr = m;
        int rlc = cc + 1;
        int rlcount = 0;
        while (rlr<N && map[rlr][rlc] == '*') {
            ++rlcount;
            rlr++;
        }

        System.out.println((cr+1) +" " + (cc+1));
        System.out.println(lcount+" "+rcount+" "+mcount+" "+llcount+" "+rlcount);
    }
}

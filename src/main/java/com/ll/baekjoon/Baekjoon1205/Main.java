package com.ll.baekjoon.Baekjoon1205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //리스트에 있는 점수
        int tesu = Integer.parseInt(st.nextToken()); //태수 점수
        int P = Integer.parseInt(st.nextToken()); //랭킹에 올라갈 수 있는 점수

        int[] rank = new int[N+1];
        if(N == 0){ //n이 0이면 뭘 주던 1위
            System.out.println(1);
            return;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            rank[i] = Integer.parseInt(st.nextToken());
        }

        if(N>=P && rank[P] >= tesu){ //N이 제한수보다 높거나 같고 //그중 마지막이 태수보다 크거나 같으면
            System.out.println(-1); //랭크 안에 못들어가
            return;
        }

        int seq = 1;

        //이거 아니면 랭크 안에 들어갈 수 있다는 거니까 탐색시작
        for(int i=1; i<=N; i++){
            seq = i+1;
            if(tesu >= rank[i]){ //태수가 크거나 같은거 찾으면
                seq = i; //등수 정해진거고
                break;
            }
        }
        System.out.println(seq);
    }
}

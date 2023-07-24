package com.ll.baekjoon.R_Baekjoon2980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[][] info = new int[N][3];


        for (int n = 0; n < N; n++) {
            st = new StringTokenizer(br.readLine());
            info[n][0] = Integer.parseInt(st.nextToken()); //거리
            info[n][1] = Integer.parseInt(st.nextToken()); //빨간거 시간
            info[n][2] = Integer.parseInt(st.nextToken()); //초록 시간
        }
        int time = 0;
        int dist = 0;
        int number = 0;
        while(dist <= L){
            time++; //시간은 계속 간다.
            if(info[number][0]==dist){ //신호등이 있는 거리라면 체크
                if(time % (info[number][1] + info[number][2]) < info[number][1]){
                    dist--;
                } else{
                    number++;
                    if(number>=N) number = 0;
                }
            }
            dist++;
        }
        System.out.println(time);
    }
}

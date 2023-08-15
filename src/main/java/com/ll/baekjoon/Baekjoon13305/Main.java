package com.ll.baekjoon.Baekjoon13305;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        //N -> 10만개 Nc2 사용X
        //long

        //기준보다 작은 기름값이 나올때까지 거리누적 후 계산 - 반복

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        //도로의 길이
        long[] dist = new long[N - 1];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N-1; i++){
            dist[i] = Long.parseLong(st.nextToken());
        }

        //주유소가격
        long[] pay = new long[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            pay[i] = Long.parseLong(st.nextToken());
        }

        long min = pay[0];
        long sum = dist[0] * min;
        for(int i=1; i<N-1; i++){
            if(pay[i] < min)
                min = pay[i];

            sum += (dist[i] * min);
        }
        System.out.println(sum);
    }
}

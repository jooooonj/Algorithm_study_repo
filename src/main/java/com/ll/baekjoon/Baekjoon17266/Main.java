package com.ll.baekjoon.Baekjoon17266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine()); //총 길의 길이
        M = Integer.parseInt(br.readLine()); // 가로등 개수

        int[] street = new int[N+1];
        int[] lamp = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            lamp[i] = Integer.parseInt(st.nextToken());
        }

        //적어도 가로등이 0까지 비추는 높이와 마지막 가로등이 마지막 길까지 비춰야 한다.
        int max = Math.max(lamp[0], N - lamp[M-1]);


        //이제 두 가로등 사이에 있는 길은 반반씩 비추면 된다.
        for(int i=0; i<M-1; i++){
            max = Math.max(max, (int)Math.ceil((lamp[i+1] - lamp[i])/2.0));
        }

        System.out.println(max);
    }
}

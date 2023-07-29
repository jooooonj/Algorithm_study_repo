package com.ll.baekjoon.Baekjoon10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;


public class Main {
    static int N;
    static int[] arr;
    static int[] tmp;
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;
    //순서 o, 중복 x
    static void fill(int depth, int index){
        if(depth==N){
            max = Math.max(max, calc());
            return;
        }

        for(int i=0; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            tmp[index] = i;
            fill(depth+1, index+1);
            tmp[index] = 0;
            visited[i] = false;
        }
    }

    static int calc(){
        int sum = 0;
        for(int i=0; i<N-1; i++){
            sum += (Math.abs(arr[tmp[i]] - arr[tmp[i+1]]));
        }
        return sum;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        StringTokenizer st;

        //N의 개수가 적기 때문에 완전 탐색 시도.
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        tmp = new int[N];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        fill(0,0);
        System.out.println(max);
    }
}

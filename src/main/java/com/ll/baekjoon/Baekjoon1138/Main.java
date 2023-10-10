package com.ll.baekjoon.Baekjoon1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] info = new int[N];
        List<Integer> result = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            info[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1; i>=0; i--){
            result.add(info[i], i+1);
        }

        for(int i=0; i<N; i++){
            System.out.print(result.get(i) +" ");
        }
    }
}

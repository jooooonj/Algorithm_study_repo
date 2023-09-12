package com.ll.baekjoon.Baekjoon2075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 낮은 수가 우선순위

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++){
                int num = Integer.parseInt(st.nextToken());

                if(pq.size() == N){
                    if(pq.peek() < num){
                        pq.poll();
                        pq.add(num);
                    }
                } else
                    pq.add(num);
            }
        }

        System.out.println(pq.peek());
    }
}

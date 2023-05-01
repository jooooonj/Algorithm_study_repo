package com.ll.baekjoon.Baekjoon1715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1715
 * 백준 1715
 * 문제풀이 : 그리디, 우선순위큐
 */
public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // 디폴트는 낮은 숫자가 우선 순위
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 높은 숫자가 우선순위인 큐 선언
//        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        for(int i =0; i<N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int sum = 0;
        while(pq.size()>1){
            int hab = pq.poll() + pq.poll();
            sum += hab;
            pq.add(hab);
        }
        System.out.println(sum);
    }
}
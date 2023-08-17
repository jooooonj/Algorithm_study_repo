package com.ll.baekjoon.R_Baekjoon21921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MAX = Integer.MIN_VALUE;
    static int maxCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] visitor = new int[N + 1];
        int[] prefixSum = new int[N+2];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        boolean isZero = true;
        for(int i=1; i<=N; i++){
            visitor[i] = Integer.parseInt(st.nextToken());
            if(visitor[i] != 0) //0이 아닌수가 오면 최대방문자수가 0은 아님.
                isZero = false;
            prefixSum[i+1] = prefixSum[i] + visitor[i];
        }

        if(isZero) { //전부 0이면 SAD 출력
            System.out.println("SAD");
            return;
        }

//        //누적합 알고리즘
//        for(int i=1; i<=N-X+1; i++){
//            sum = prefixSum[i+X] - prefixSum[i]; //i ~ i+X 합
//
//            if(sum > MAX){
//                MAX = sum;
//                maxCount = 1;
//            } else if(sum == MAX){
//                maxCount++;
//            }
//        }

        //슬라이딩 윈도우 알고리즘
        for(int i=1; i<=X; i++){ //일단 가장 처음부터 X일동안 방문자수 세어
            sum += visitor[i];
        }
        maxCount = 1;
        MAX = sum;

        for(int i=X+1; i<=N; i++){
            sum += visitor[i]; //다음 한칸 더해주고
            sum -= visitor[i-X]; //뒤에 한칸 빼주고

            if(sum > MAX){
                MAX = sum;
                maxCount = 1;
            } else if(sum == MAX){
                maxCount++;
            }
        }
        System.out.println(MAX);
        System.out.println(maxCount);
    }
}

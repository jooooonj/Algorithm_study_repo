package com.ll.SW_Expert_Academy.sw1859_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        //맨 뒤부터 최대값 갱신 -> 새로 최대값 갱신될때 개수만큼 기존 최댓값에 팔기

        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            int count = 0;
            long benefit = 0;
            int money = 0;

            for(int i=arr.length - 1; i>=0; i--){
                if(arr[i] > max){
                    max = arr[i];
                } else{
                    benefit += (max - arr[i]);
                }
            }

            sb.append("#"+t+" "+benefit+"\n");
        }
        System.out.println(sb.toString());
    }
}

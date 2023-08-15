package com.ll.baekjoon.Baekjoon2512;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long total = Integer.parseInt(br.readLine());

        int right = arr[N-1];
        int left = 0;

        long answer = 0;
        while(left<=right){
            long sum = 0; //분배한 예산
            int mid = (left + right) / 2; //상한가

            for(int i=0; i<N; i++){
                if(mid < arr[i]) sum += mid; //일단 상한가 가져가
                else sum += arr[i]; //너 적은만큼 줄게
            }

            if(sum <= total){
                //총 예산액보다 적거나 같으면 일단 갱신
                left = mid + 1; // 상한가좀 높여보자
                answer = Math.max(answer, mid);
            }
            else
                right = mid - 1; //높으면 상한가 줄이자
        }

        System.out.println(answer);
    }
}

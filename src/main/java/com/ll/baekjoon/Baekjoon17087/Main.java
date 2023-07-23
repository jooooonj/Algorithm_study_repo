package com.ll.baekjoon.Baekjoon17087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //수빈이의 위치와 동생들의 위치를 구한 후 최대공약수를 구한다.
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int point = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] points = new int[N];
        for(int i=0; i<N; i++){
            points[i] = Math.abs(Integer.parseInt(st.nextToken()) - point);
        }

        int result = result(points);
        System.out.println(result);
    }
    public static int result(int[] arr){
        int result = arr[0];
        for(int i=1; i<arr.length; i++){
            result = calc(result, arr[i]);
        }
        return result;
    }

    public static int calc(int a, int b){
        if(a == 0) return b;

        return calc(b%a, a);
    }
}

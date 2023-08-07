package com.ll.baekjoon.R_Baekjoon2304;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int L;
    static int H;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //제일 높은거 찾기
        //좌,우에서 제일높은거까지 자기보다 높은거 찾기

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        int max = 0;
        int maxL = -1;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            if(max < arr[i][1]){
                max = arr[i][1];
                maxL = arr[i][0];
            }
        }

        Arrays.sort(arr, new Comparator<int[]>(){

            public int compare(int[] a1, int[] a2){
                return a1[0] - a2[0];
            }
        });

        int sum = max;
        int m = arr[0][1];
        int n = arr[0][0];
        //왼쪽
        for(int i=0; i<N; i++){
            if(m <= arr[i][1]){
                sum += m * (arr[i][0] - n);
                m = arr[i][1];
                n = arr[i][0];
            }
            if(arr[i][0] == maxL) {
                break;
            }

        }

        //오른족
        m = arr[N-1][1];
        n = arr[N-1][0];
        for(int i=N-1; i>=0; i--){
            if(m <= arr[i][1]){
                sum += m * (n - arr[i][0]);
                m = arr[i][1];
                n = arr[i][0];
            }

            if(arr[i][0] == maxL) {
                break;
            }

        }

        System.out.println(sum);
    }
}

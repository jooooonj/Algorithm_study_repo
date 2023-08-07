package com.ll.baekjoon.R_Baekjoon10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        boolean perfect = true;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] != N-i)
                perfect = false;
        }

        if(perfect){
            System.out.println(-1);
            System.exit(0);
        }

        for (int i = N - 1; i > 0; i--) {
            if (arr[i - 1] < arr[i]) { //뒤가 앞보다 큰 경우를 찾는다.

                int num = arr[i-1];
                int dif = Integer.MAX_VALUE;
                int index = -1;
                
                for(int j=i; j<N; j++){
                    if(num < arr[j]){
                        if(dif > arr[j] - num){
                            dif = arr[j] - num;
                            index = j;
                        }
                    }
                }
                //가장 적게 차이나는 애랑 스왑해준다.
                int tmp = arr[i-1];
                arr[i-1] = arr[index];
                arr[index] = tmp;


                //정렬
                for(int j=i; j<N-1; j++){
                    for(int k=j+1; k<N; k++){
                        if(arr[j] > arr[k]){
                            int t = arr[j];
                            arr[j] = arr[k];
                            arr[k] = t;
                        }
                    }
                }
                break;
            }

        }
        for(int i=0; i<N; i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb);
    }
}

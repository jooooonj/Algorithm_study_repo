package com.ll.baekjoon.Baekjoon1758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    //최대한 많이 살아야지 최대한 많은 팁을 받는다.
    static int N;
    static Integer[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new Integer[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        long sum = 0;
        for(int i=0; i<N; i++){
            if(arr[i] - i <= 0)
                break;
            sum += arr[i] - i;
        }

        System.out.println(sum);
    }
}

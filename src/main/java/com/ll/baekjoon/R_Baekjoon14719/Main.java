package com.ll.baekjoon.R_Baekjoon14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int result = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        //왼쪽에 자기보다 높은 기둥이 있어야 한다.
        //오른쪽에 자기보다 높은 기둥이 있어야 한다.
        //더 작은 기둥 - 자신
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] h = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            h[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<W-1; i++){
            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;
            for(int j=0; j<i; j++){
                left = Math.max(left, h[j]);
            }

            for(int j=i+1; j<W; j++){
                right = Math.max(right, h[j]);
            }

            if(h[i]<left && h[i]<right){
                result += Math.min(left,right) - h[i];
            }
        }

        System.out.println(result);
    }
}

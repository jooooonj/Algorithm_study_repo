package com.ll.baekjoon.Baekjoon1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        long x = Integer.parseInt(st.nextToken());
        long y = Integer.parseInt(st.nextToken());

        long z = (y * 100) / x;
        long obj = z;
        long count = 0;

        if(z == 100){
            System.out.println(-1);
            System.exit(0);
        }
        while(z <= obj){
            count++;
            x++;
            y++;
            z = (y*100) / x;
            
            if(z >obj){
            }
        }
        System.out.println(count);
    }
}

package com.ll.baekjoon.Baekjoon14582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] ulim = new int[9];
    static int[] start = new int[9];
    public static void main(String[] args) throws IOException {
        //역전패 -> 불펜 투수
        //역전패X -> 타자, 선발투수

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<9; i++){
            ulim[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int j=0; j<9; j++){
            start[j] = Integer.parseInt(st.nextToken());
        }

        boolean isYes = false;
        int ulimScore = 0;
        int startScore= 0;
        for(int i=0; i<9; i++){
            ulimScore += ulim[i];
            if(ulimScore > startScore)
                isYes = true;
            startScore += start[i];
        }

        if(isYes == true)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}

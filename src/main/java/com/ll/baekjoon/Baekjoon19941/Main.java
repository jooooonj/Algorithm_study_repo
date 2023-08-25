package com.ll.baekjoon.Baekjoon19941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int K;
    static boolean[] eat;
    static int result = Integer.MIN_VALUE;


    static void dfsL(char[] point, int start, int count) {
        result = Math.max(result, count);
        if(start >= point.length) return;

        if(point[start] == 'H'){
            dfsL(point, start+1, count);
        } else{ //사람이면

            for(int i = start - K; i<=start + K; i++){ //왼쪽부터 탐색
                if(i<0 || i>=point.length) continue; //범위 넘으면 continue
                if(point[i] == 'H' && !eat[i]){//햄버거 찾으면 일단 먹어 너가 최선이야
                    eat[i] = true;
                    dfsL(point, start+1, count+1);
                    return;
                }
            }

            //여기까지 왔다는 건 햄버거가 없다는거지?
            dfsL(point, start+1, count);
        }
    }

    static void dfsR(char[] point, int start, int count) {

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); //식탁의 길이
        K = Integer.parseInt(st.nextToken()); //햄버거 선택 가능한 길이

        char[] point = br.readLine().toCharArray(); //햄버거와 사람 위치
        eat = new boolean[point.length];

        dfsL(point, 0, 0);
        System.out.println(result);
    }
}

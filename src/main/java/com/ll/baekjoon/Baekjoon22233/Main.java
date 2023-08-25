package com.ll.baekjoon.Baekjoon22233;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken()); //글의 개수

        Map<String, Boolean> memo = new HashMap<>();
        int memoCount = 0;
        for(int i=0; i<N; i++){
            memoCount++;
            memo.put(br.readLine(), true);
        }

        for(int i=0; i<M; i++){
            String tmp = br.readLine();
            String[] words = tmp.split(",");
            for (String word : words) {
                if (memo.containsKey(word)) {
                    memo.remove(word);
                    memoCount--;
                }
            }
            sb.append(memoCount + "\n");
        }
        System.out.println(sb);
    }
}

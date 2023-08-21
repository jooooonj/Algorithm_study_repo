package com.ll.baekjoon.Baekjoon25757;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int minimum;
        String word = st.nextToken();
        if(word.equals("Y"))
            minimum = 2;
        else if(word.equals("F"))
            minimum = 3;
        else
            minimum = 4;

        Set<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        int count = 0;
        count = set.size() / (minimum - 1); //임스빼고
        System.out.println(count);
    }
}

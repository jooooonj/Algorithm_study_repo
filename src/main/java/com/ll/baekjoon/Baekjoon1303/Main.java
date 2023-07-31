package com.ll.baekjoon.Baekjoon1303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];
        List<String> words = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (!words.contains(word))
                words.add(word);
            numbers[words.indexOf(word)]++;
        }

        int max = -1;
        for(int i=0; i<N; i++){
            max = Math.max(max, numbers[i]);
        }

        List<String> list = new ArrayList<>();
        for(int i=0; i<N; i++){
            if(numbers[i] == max)
                list.add(words.get(i));
        }
        Collections.sort(list);

        System.out.println(list.get(0));
    }
}

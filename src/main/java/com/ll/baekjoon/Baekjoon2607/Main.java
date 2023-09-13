package com.ll.baekjoon.Baekjoon2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];

        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine();
        }

        String str = words[0]; //기준

        // 기준보다 길이가 1 작은 경우 -> 기준이 상대방 단어를 전부 포함하고 있어야 한다.
        // 기준보다 길이가 1 큰 경우 -> 상대방이 기준의 단어를 전부 포함하고 있어야 한다.
        // 기준이랑 길이가 같은 경우 -> 기준과 상대방 단어가 일치할때, 기준과 상대방 단어가 1개 빼고 일치할때
        int count = 0;
        for (int i = 1; i < N; i++) {
            String target = words[i];
            if (Math.abs(target.length() - str.length()) > 1) continue;

            int[] alpha = new int[26];
            for(int j=0; j<str.length(); j++){
                alpha[str.charAt(j) - 'A']++;
            }

            int cnt = 0;
            for(int j=0; j<target.length(); j++){
                if(alpha[target.charAt(j) - 'A'] > 0) cnt++;
                alpha[target.charAt(j) - 'A'] --;
            }

            if(target.length() == str.length() && (target.length() == cnt || target.length() - 1 == cnt)) count++; //길이 같은 경우
            else if(target.length() == str.length() + 1 && str.length() == cnt) count++;  //기준보다 비교값이 긴 경우
            else if(target.length() + 1 == str.length() && cnt  == str.length() - 1) count++; //기준이 더 긴 경우
        }

        System.out.println(count);
    }
}

package com.ll.baekjoon.Baekjoon1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        String[] arr = new String[a];
        Map<String, Integer> map1 = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();

        for (int i = 0; i < a; i++) {
            String str = br.readLine();
            map1.put(str, i + 1);
            map2.put(i + 1, str);
        }

        for (int i = 0; i < b; i++) {
            String str = br.readLine();
            char ch = str.charAt(0);
            if (ch >= '0' && ch <= '9')
                sb.append(map2.get(Integer.parseInt(str)) + "\n");
            else
                sb.append(map1.get(str) + "\n");
        }
        System.out.println(sb);
    }
}

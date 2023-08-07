package com.ll.baekjoon.R_Baekjoon5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //o가 1개일때마다 확인
        int l = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int result = 0;
        int count = 0;
        for (int i = 1; i < l - 1; i++) {
            char ch = str.charAt(i);

            if (ch == 'O' && str.charAt(i + 1) == 'I') {
                count++;


                if (count == N) {
                    if (str.charAt(i - (count * 2 - 1)) == 'I') {
                        result++;
                    }
                    count--;
                }

                i++;
            } else{
                count = 0;
            }

        }
        System.out.println(result);
    }
}

package com.ll.baekjoon.Baekjoon5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int length = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int count = 0;
        int result = 0;
        for (int i = 1; i < length - 1;) {
            if (str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                count++;

                if(count == N){
                    if(str.charAt(i - (count*2-1)) == 'I')
                        result++;
                    count--;
                }

                i += 2;

            } else{
                count = 0;
                i++;
            }
        }

        System.out.println(result);
    }
}

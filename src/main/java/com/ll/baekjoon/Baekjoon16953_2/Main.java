package com.ll.baekjoon.Baekjoon16953_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //1이면 빼고, 1이 아니면 2로 나누어준다. a보다 작아지면 -1 리턴
        //1 안빠지고 2로도 안나누어 떨어지면 -1리턴
        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int count = 1;
        while(b>a){
            count++;
            String tmp = String.valueOf(b);

            if(tmp.charAt(tmp.length() - 1) == '1'){
                b  /= 10;
            }

            else{
                if(b % 2 != 0){
                    System.out.println(-1);
                    System.exit(0);
                } else{
                    b /= 2;
                }
            }
        }

        if(a==b)
            System.out.println(count);
        else
            System.out.println(-1);
    }
}

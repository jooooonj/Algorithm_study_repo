package com.ll.baekjoon.Baekjoon5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String str = "I";
        for(int i=0; i<N; i++){
            str += "OI";
        }

        int length = Integer.parseInt(br.readLine());
        String word = br.readLine();

        int count = 0;
        while(true){
            int index = word.indexOf('I');
            if(index<0) break;

            word = word.substring(index+1);

            if(!(word.length() >= N*2))
                break;
            String s = "I";
            for(int i=0; i<N*2; i++){
                if(i%2==0)
                    if(word.charAt(i)=='I')
                        break;
                else
                    if(word.charAt(i)=='O')
                        break;
                s += word.charAt(i);
            }

            if(s.equals(str))
                count++;
        }
        System.out.println(count);
    }
}

package com.ll.SW_Expert_Academy.sw1989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int result = 1;
            String str = br.readLine();
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) != str.charAt(str.length()-1-i)){
                    result = 0;
                }
            }

            sb.append("#"+t+" "+result +"\n");
        }
        System.out.println(sb);
    }
}


package com.ll.SW_Expert_Academy.sw1946;

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
            int N = Integer.parseInt(br.readLine());
            String str = "";
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                int repeat = Integer.parseInt(st.nextToken());

                for(int j=0; j<repeat; j++){
                    str += s;
                }
            }


            sb.append("#"+t+"\n");
            for(int i=0; i<str.length(); i++){
                if(i!=0 && i%10==0)
                    sb.append("\n");
                sb.append(str.charAt(i));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

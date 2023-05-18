package com.ll.SW_Expert_Academy.sw5431;

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
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            boolean[] suc = new boolean[N+1];

            int SucCount = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<SucCount; i++){
                suc[Integer.parseInt(st.nextToken())] = true;
            }

            sb.append("#"+t);
            for(int i=1; i<=N; i++){
                if(!suc[i])
                    sb.append(" "+i);
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
}


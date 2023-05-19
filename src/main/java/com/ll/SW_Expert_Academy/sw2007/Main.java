package com.ll.SW_Expert_Academy.sw2007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int result = 0;
            String str = br.readLine();
            for(int i=1; i<str.length()/2; i++){
                if(str.substring(0,i).equals(str.substring(i,i*2))){
                    result = i;
                    break;
                }
            }

            sb.append("#" + t + " " + result + "\n");
        }
        System.out.println(sb);
    }
}

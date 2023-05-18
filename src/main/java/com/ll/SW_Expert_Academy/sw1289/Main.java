package com.ll.SW_Expert_Academy.sw1289;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int count = 0;
            String s = br.readLine();
            int[] arr = new int[s.length()];

            for(int i=0; i<arr.length; i++){
                arr[i] = s.charAt(i)-'0';
            }

            for(int i=arr.length - 1; i>0; i--){
                if(arr[i] != arr[i-1]){
                    count++;
                }
            }

            if(arr[0]==1) count++;

            sb.append("#"+t+" "+count+"\n");
        }
        System.out.println(sb);
    }
}

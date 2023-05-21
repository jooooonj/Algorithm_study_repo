package com.ll.SW_Expert_Academy.sw1288;

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
        for(int t=1;  t<=T; t++){
            int num = Integer.parseInt(br.readLine());
            int[] arr = new int[10];
            int count = 1;
            String n = "";
            while(true){
                n = String.valueOf(num * count);
                for(int i=0; i<n.length(); i++){
                    arr[n.charAt(i) - '0']++;
                }

                boolean isSuccess = true;

                for(int i=0; i<arr.length; i++){
                    if(arr[i] <= 0){
                        isSuccess = false;
                        break;
                    }
                }

                if(isSuccess)
                    break;

                count++;
            }

            sb.append("#" + t + " " + n + "\n");
        }
        System.out.println(sb);
    }
}

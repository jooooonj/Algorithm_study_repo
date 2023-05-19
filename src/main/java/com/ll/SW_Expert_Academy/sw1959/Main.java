package com.ll.SW_Expert_Academy.sw1959;

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
            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());

            //A가 더 긴 배열
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());


            int [] arr1 = new int[A];
            int [] arr2 = new int[B];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<A; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<B; i++){
                arr2[i] = Integer.parseInt(st.nextToken());
            }

            if(A>B){
                for(int i=0; i<=A-B; i++){
                    int sum = 0;
                    for(int j=0; j<B; j++){
                        sum += (arr2[j] * arr1[i+j]);
                    }
                    max = Math.max(sum, max);
                }
            } else{
                for(int i=0; i<=B-A; i++){
                    int sum = 0;
                    for(int j=0; j<A; j++){
                        sum += (arr1[j] * arr2[i+j]);
                    }
                    max = Math.max(sum, max);
                }
            }

            sb.append("#"+t+" "+max+"\n");
        }
        System.out.println(sb);
    }
}

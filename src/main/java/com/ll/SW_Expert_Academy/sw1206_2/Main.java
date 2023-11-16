package com.ll.SW_Expert_Academy.sw1206_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 10;

        for(int t=1; t<=T; t++){
            int result = 0;

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=2; i<N-2; i++){
                if(arr[i] > arr[i-1] && arr[i] > arr[i-2] && arr[i] > arr[i+1] && arr[i] > arr[i+2]){
                    //양쪽 두번째까지 비교해서 제일 크다면,
                    //전부 비교해서 최대값 뽑아
                    int max = Math.max(arr[i-1], arr[i-2]);
                    max = Math.max(max,arr[i+1]);
                    max = Math.max(max,arr[i+2]);

                    result += (arr[i] - max);
                }
            }

            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb.toString());
    }
}

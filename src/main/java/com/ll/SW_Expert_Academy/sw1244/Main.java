package com.ll.SW_Expert_Academy.sw1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int limit;
    static int max;
    static boolean[] visited;
    static void swap(char[] arr, int a, int b){
        char tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    static void calc(char[] num, int count){
        if(count == limit){
            int sum = 0;
            int e = 1;
            for(int i=num.length - 1; i>=0; i--){
                sum += ((num[i]-'0') * e);
                e *= 10;

            }
            max = Math.max(max,sum);
            return;
        }


        for(int i=0; i<num.length-1; i++){
            for(int j=i; j<num.length; j++){
                if(i==j)continue;
                swap(num, i, j);
                calc(num, count+1);
                swap(num, j, i);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());

            char[] num = st.nextToken().toCharArray();
            visited = new boolean[num.length];
            limit = Integer.parseInt(st.nextToken());

            if(limit > num.length)
                limit = num.length;

            calc(num,0);

            sb.append("#"+t+" " + max + "\n");
        }
        System.out.println(sb);
    }
}

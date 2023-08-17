package com.ll.baekjoon.Baekjoon11501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            //오름차순인 경우에 주식 사고 최고점에 팔기 반복
            long total = 0; //순이익
            long stock = 0; //주식개수

            int max = arr[N-1];
            for(int i=N-2; i>=0; i--){
                if(arr[i] > max){ //뒤에서부터 최고가격을 찾는다.
                    total += (stock * max); //이전 최고가격에 주식들 다 팔아.
                    stock = 0;
                    max = arr[i]; //최고가격 갱신해
                } else { //낮으면 계속 주식 모아
                    stock ++;
                    total -= arr[i];
                }
            }

            if(stock>0) //남은 주식있으면 최고가에 다판다.
                total += (stock * max);
            sb.append(total+"\n");
        }
        System.out.print(sb);
    }
}

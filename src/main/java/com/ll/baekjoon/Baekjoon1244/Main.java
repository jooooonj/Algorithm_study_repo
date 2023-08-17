package com.ll.baekjoon.Baekjoon1244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int change(int num){
        if(num==1)
            return 0;
        else
            return 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] swi = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            swi[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine()); //학생수
        //성별 1:남자 2:여자
        int[][] stu = new int[M][2];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken()); //성별 1 or 2
            int num = Integer.parseInt(st.nextToken()); //스위치 번호

            if(gender == 1){ //남자
                for(int j=1; j<=N; j++){
                    if(j%num==0) //배수이면 change
                        swi[j] = change(swi[j]);
                }
            } else{ // 여자
                int left = num - 1;
                int right = num + 1;
                while(true){
                    if(left < 1 || right > N) break; //범위 넘어가면 stop
                    if(swi[left] != swi[right]) break;
                    left--;
                    right++;
                }

                for(int j=left+1; j<=right-1; j++){
                    swi[j] = change(swi[j]);
                }
            }
        }

        for(int i=1; i<=N; i++){
            if(i!=1 && i%20==1)
                System.out.println();
            System.out.print(swi[i]+" ");
        }


    }
}

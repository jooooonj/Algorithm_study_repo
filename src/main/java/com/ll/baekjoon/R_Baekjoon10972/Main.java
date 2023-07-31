package com.ll.baekjoon.R_Baekjoon10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static List<String> list;
    static boolean visited[];
    static void dfs(int depth, String str){
        if(depth == N){
            list.add(str);
        }

        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            else{
                visited[i] = true;
                dfs(depth+1, str += i+" ");
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] num = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        int index = -1;
        for(int i=N-1; i>0; i--){
            if(num[i] > num[i-1]){

                int dif = Integer.MAX_VALUE;
                int index2 = -1;
                for(int j=i; j<N ;j++){
                    if(num[j] > num[i-1] && dif > num[j] - num[i-1]){
                        dif = num[j] - num[i-1];
                        index2 = j;
                    }
                }
                int tmp = num[index2];
                num[index2] = num[i -1];
                num[i-1] = tmp;

                index = i;
                break;
            }
        }

        if(index == -1){
            System.out.println(-1);
        } else{
            int[] tmp = new int[N-index];
            int x = 0;
            for(int i=index; i<N; i++){
                tmp[x++] = num[i];
            }
            Arrays.sort(tmp);

            for(int i=0; i<index; i++){
                System.out.print(num[i]+" ");
            }
            for(int i=0; i<tmp.length; i++){
                System.out.print(tmp[i]+" ");
            }
        }
    }
}

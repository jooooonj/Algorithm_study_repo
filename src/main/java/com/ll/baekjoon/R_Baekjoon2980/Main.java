package com.ll.baekjoon.R_Baekjoon2980;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Tr{
        int d;
        int red;
        int green;

        Tr(int red, int green){
            this.red=red;
            this.green=green;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        Map<Integer, Tr> map = new HashMap<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            map.put(d, new Tr(red, green));

        }

        int time = -1;
        for(int i=1; i<=L; i++){
            time++; //시간은 계속 흐른다.

            if(map.containsKey(i)){
                Tr curr = map.get(i);

                if(time % (curr.red+curr.green) < curr.red){
                    i--;
                }
            }
        }
        System.out.println(time);
    }
}

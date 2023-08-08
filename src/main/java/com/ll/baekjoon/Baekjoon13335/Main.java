package com.ll.baekjoon.Baekjoon13335;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; //트럭수
    static int W; //다리길이
    static int L; //최대하중
    static Truck[] trucks;

    static class Truck{
        int weight;
        int dist;
        Truck(int weight, int dist){
            this.weight = weight;
            this.dist = dist;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        trucks = new Truck[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int weight = Integer.parseInt(st.nextToken());
            trucks[i] = new Truck(weight, 0);
        }

        //시뮬레이션
        int time = 0;
        int currL = 0;
        int next = 0; //다음 차례
        int curr = 0; //현재 다리위에 있는 제일 빠른놈

        //마지막 트럭이 다리에 진입하면 종료
        //답 : time + 거리(마지막트럭이 다 건너는 시간)
        while(next<N){
            time++;

            if(currL + trucks[next].weight <= L){
                currL += trucks[next].weight;
                next++;
            }

            for(int i=curr; i<next; i++){
                trucks[i].dist++;

                if(trucks[i].dist == W){
                    curr = i+1;
                    currL -= trucks[i].weight;
                }
            }
        }

        System.out.println(time+W); //
    }
}

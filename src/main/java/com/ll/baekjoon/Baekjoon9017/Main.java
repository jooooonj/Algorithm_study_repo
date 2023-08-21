package com.ll.baekjoon.Baekjoon9017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int T;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            int[] teamNum = new int[201];
            List<Integer> list = new ArrayList<>();

            for(int i=1; i<=N; i++){
                int num = Integer.parseInt(st.nextToken());
                list.add(num); //들어온 순서대로 기록해놔 우선
                teamNum[num]++; //그 팀 몇명인지도 세고
            }

            for(int j=1; j<=200; j++){
                if(teamNum[j] > 0 && teamNum[j] < 6) //만약 한명보다 많고 6명보다 작으면 다 없애
                    while(list.remove(Integer.valueOf(j)));
            }


            Map<Integer, Integer> winners = new HashMap<>();
            Map<Integer, Integer> fifth = new HashMap<>();
            int[] seq = new int[201];
            for(int j=0; j<list.size(); j++){
                seq[list.get(j)]++;

                if(seq[list.get(j)] <= 4){
                    if(!winners.containsKey(list.get(j)))
                        winners.put(list.get(j), 0); //team번호에 점수부여
                    winners.put(list.get(j), winners.get(list.get(j)) + j);
                } else if(seq[list.get(j)] == 5){
                    fifth.put(list.get(j), j); //5번째 들어온애 점수 (낮아야됨)
                }
            }

            int min = Integer.MAX_VALUE;
            int result = -1;
            for(int n : list){
                if(min > winners.get(n)){
                    min = winners.get(n);
                    result = n;
                } else if(min == winners.get(n)){
                    if(fifth.get(result) > fifth.get(n)){
                        result = n;
                    }
                }
            }

            sb.append(result + "\n");
        }
        System.out.println(sb);
    }
}

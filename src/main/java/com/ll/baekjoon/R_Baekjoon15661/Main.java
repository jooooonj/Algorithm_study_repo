package com.ll.baekjoon.R_Baekjoon15661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[] isStart; //스타트팀인지

    static void calc() {
        int startPower = 0;
        int linkPower = 0;
        List<Integer> startTeam = new ArrayList<>();
        List<Integer> linkTeam = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            //start
            if (isStart[i] == true) {
                startTeam.add(i);
                //link
            } else {
                linkTeam.add(i);
            }
        }

        //실제계산
        for(int i=0; i<startTeam.size()-1; i++){
            for(int j=i+1; j<startTeam.size(); j++){
                int a = startTeam.get(i);
                int b=  startTeam.get(j);
                startPower += (map[a][b] + map[b][a]);
            }
        }

        for(int i=0; i<linkTeam.size(); i++){
            for(int j=i+1; j<linkTeam.size(); j++){
                int a = linkTeam.get(i);
                int b=  linkTeam.get(j);
                linkPower += (map[a][b] + map[b][a]);
            }
        }

        min = Math.min(Math.abs(startPower - linkPower), min);
    }

    static void dfs(int num, int depth){
        calc();

        if(depth == N){ //
            return;
        }

        for(int i=num+1; i<N; i++){
            if(isStart[i]) continue;
            isStart[i] = true;
            dfs(i,depth+1);
            isStart[i] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        isStart = new boolean[N];
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //인원수의 불균형 상관없음
        //1명 이상만 들어가면됨

        for(int i=0; i<N; i++){
            isStart[i] = true;
            dfs(i,1);
            isStart[i] = false;
        }

        System.out.println(min);
    }
}

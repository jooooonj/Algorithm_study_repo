package com.ll.baekjoon.Baekjoon1446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int goal;
    static Path[] paths;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE; //최소운전거리
    static class Path{
        int s;
        int e;
        int d;

        public Path(int s, int e, int d){
            this.s=s;
            this.e=e;
            this.d=d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        paths = new Path[N];

        visited = new boolean[N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            paths[i] = new Path(s,e,d);
        }


        Arrays.sort(paths, (path1, path2) -> {
            return path1.s - path2.s;
        });

        //완탐
        dfs(0,0); //현재위치,운전한거리
        System.out.println(min);
    }

    static void dfs(int curr, int dist){
        if(curr > goal) return;
        if(dist >= min) return;

        else if(curr==goal){
            min = Math.min(min, dist); //거리비교
            return;
        }

        for(int i=0; i<N; i++){
            if(paths[i].s < curr) continue; //현재보다 지름길 시작위치가 전이라면 패스

            //지름길 타고 나온 위치가 현재위치, 지금까지 달린거리 + 시작지점까지의 거리 + 지름길거리
            dfs(paths[i].e, dist + (paths[i].s-curr) + paths[i].d);
        }

        min = Math.min(goal-curr + dist, min);
        return;
    }
}

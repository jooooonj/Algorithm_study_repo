package com.ll.programers.level2.p43162;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
}

class Solution {
    static boolean[] visited;
    static int count = 0;
    static int N;
    public int solution(int n, int[][] computers) {
        //연결되어 있는거 전부 방문처리

        //연결 안되어 있는거 시작할때마다 cnt증가처리
        N = n;
        visited = new boolean[n];

        for(int i=0; i<N; i++){
            if(!visited[i]){
                count++;
                bfs(computers, i);
            }
        }

        return count;
    }

    public void bfs(int[][] computers, int start){
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true;

        while(!q.isEmpty()){
            int current = q.poll();

            for(int i=0; i<N; i++){
                if(visited[i]) continue; // 중복검사
                if(computers[current][i] == 0) continue; //간선검사

                //방문처리
                visited[i] = true;
                q.add(i);
            }
        }
    }

}

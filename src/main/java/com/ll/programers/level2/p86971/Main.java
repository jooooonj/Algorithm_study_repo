package com.ll.programers.level2.p86971;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        int[][] v = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int n = 9;
        s.solution(n, v);
    }
}

class Solution {
    static int min = Integer.MAX_VALUE;
    static int[][] graph;
    public int solution(int n, int[][] wires) {
        // 그래프 구현
        graph = new int[n+1][n+1];

        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        //끊었다고 가정하고 각각 연결된 노드의 수를 카운팅
        for(int i=0; i<wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a][b] = 0;
            graph[b][a] = 0;

            int aCount = bfs(a, n);
            int bCount = bfs(b, n);
            min = Math.min(min, Math.abs(aCount - bCount));

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        return min;
    }

    public int bfs(int node, int n){
        int count = 0;
        boolean[] visited = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();

        visited[node] = true;
        q.add(node);

        while(!q.isEmpty()){
            int num = q.poll();

            for(int i=1; i<=n; i++){
                if(!visited[i] && graph[num][i] == 1){
                    visited[i] = true;
                    q.add(i);
                    count++;
                }
            }
        }

        return count;
    }
}
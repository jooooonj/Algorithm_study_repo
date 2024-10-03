package com.ll.programers.level2.p12978;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
}

class Solution {
    public List<List<Node>> graph = new ArrayList<>();
    public boolean[] visited;
    public int[] dist;
    public int solution(int N, int[][] road, int K) {

        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for(int i=0; i<=N; i++){
            graph.add(new ArrayList<>());
        }

        // 간선 비용 넣어주기
        for(int i=0; i<road.length; i++){
            int a = road[i][0];
            int b = road[i][1];
            int cost = road[i][2];

            graph.get(a).add(new Node(b, cost));
            graph.get(b).add(new Node(a, cost));
        }

        dikstra(1);

        int count = 0;
        for(int i=1; i<dist.length; i++){
            if(dist[i] <= K){
                count++;
            }
        }

        return count;

    }

    public void dikstra(int startIndex){
        dist[startIndex] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);

        pq.offer(new Node(startIndex, 0));

        while(!pq.isEmpty()){
            Node currentNode = pq.poll();
            if(visited[currentNode.index]){
                continue;
            }

            visited[currentNode.index] = true;

            for(Node node : graph.get(currentNode.index)){
                if(dist[node.index] > dist[currentNode.index] + node.cost){
                    dist[node.index] = dist[currentNode.index] + node.cost;
                    pq.offer(new Node(node.index, dist[node.index]));
                }
            }
        }
    }

    public class Node{
        public int index;
        public int cost;

        public Node(int index, int cost){
            this.index = index;
            this.cost = cost;
        }
    }
}
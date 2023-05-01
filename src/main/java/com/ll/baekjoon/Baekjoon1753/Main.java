package com.ll.baekjoon.Baekjoon1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int E;
    static List<Node> list;
    static boolean[] visited;
    static int[] dist;
    static int INF = Integer.MAX_VALUE;
    static PriorityQueue<Node> q;
    static List<Node>[] listArr;

    static void gogo(int s){
        q.add(new Node(s, 0));

        while (!q.isEmpty()) {
            Node currNode = q.poll();
            int curr = currNode.num;

            if(visited[curr]) continue;
            visited[curr] = true;

            for(Node node : listArr[curr]){
                if(visited[node.num]) continue;
                if(node.dist + currNode.dist < dist[node.num]){
                    dist[node.num] = node.dist + currNode.dist;
                    q.add(new Node(node.num, dist[node.num]));
                }
            }

        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        visited = new boolean[N + 1];
        dist = new int[N+1];
        listArr = new List[N + 1];

        q = new PriorityQueue<>();

        Arrays.fill(dist, INF);

        int s = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++){
            listArr[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            listArr[a].add(new Node(b, value)); //a에서 b까지 거리 : value
        }

        dist[s] = 0;

        gogo(s);

        for(int i=1; i<=N; i++){
            if(dist[i]==Integer.MAX_VALUE)
                sb.append("INF").append("\n");
            else
                sb.append(dist[i]).append("\n");

        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int num;
        int dist;

        public Node(int num, int dist) {
            this.num = num;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return this.dist - o.dist; //오름차순
        }
    }
}

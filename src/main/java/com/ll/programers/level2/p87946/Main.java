package com.ll.programers.level2.p87946;

public class Main {
}

class Solution {
    static boolean[] visited;
    static int max = Integer.MIN_VALUE;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        explore(dungeons, 0, k);

        return max;
    }

    public void explore(int[][] dungeons, int depth, int hp){
        max = Math.max(max, depth);

        for(int i=0; i<dungeons.length; i++){
            if(visited[i]) continue;

            int[] dungeon = dungeons[i];
            if(dungeon[0] <= hp){
                visited[i] = true;
                explore(dungeons, depth+1, hp-dungeon[1]);
                visited[i] = false;
            }
        }
    }
}

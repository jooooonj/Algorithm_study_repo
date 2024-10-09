package com.ll.programers.level2.p1844;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
}

class Solution {
    static int[] dr = {0, -1 , 0 ,1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    static int R;
    static int C;
    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        visited = new boolean[R][C];

        int answer = bfs(maps);
        return answer;
    }

    public int bfs(int[][] maps){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(R-1, C-1, 1));
        visited[R-1][C-1] = true;

        while(!q.isEmpty()){
            Point current = q.poll();

            if(current.r == 0 && current.c == 0){
                return current.dist;
            }

            for(int i=0; i<4; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
                if(visited[nr][nc]) continue;
                if(maps[nr][nc] == 0) continue;

                q.add(new Point(nr, nc, current.dist + 1));
                visited[nr][nc] = true;
            }
        }

        return -1;

    }

    public class Point{
        int r;
        int c;
        int dist;

        public Point(int r, int c, int dist){
            this.r = r;
            this.c = c;
            this.dist = dist;
        }
    }
}

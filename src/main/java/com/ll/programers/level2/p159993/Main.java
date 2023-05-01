package com.ll.programers.level2.p159993;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
        String[] maps2 = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};

        Solution s = new Solution();
        s.solution(maps);
    }
}

class Solution {
    static class Point{
        int r;
        int c;
        int time = 0;
        Point(){};
        Point(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }

    }

    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int R;
    static int C;
    static char[][] map;
    public int solution(String[] maps) {
        R = maps.length;
        C = maps[0].length();
        map = new char[R][C];

        Point start = new Point();
        Point mid = new Point();
        Point end = new Point();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = maps[i].charAt(j);

                if(map[i][j]=='S'){
                    start.r = i;
                    start.c = j;
                }
                if(map[i][j]=='L'){
                    mid.r=i;
                    mid.c=j;
                }
                if(map[i][j]=='E'){
                    end.r=i;
                    end.c=j;
                }
            }
        }

        int lever = bfs(start, mid);
        int goal = bfs(mid, end);
        if(lever ==- 1 || goal == -1)
            return -1;

        return lever + goal;
    }

    static int bfs(Point start, Point goal){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];

        q.add(start);
        visited[start.r][start.c] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;

            if(cr==goal.r && cc == goal.c){
                return curr.time;
            }


            for(int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                //맵을 넘어가면 패스, 방문한 곳이라면 패스, 벽이면 패스
                if (nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 'X') continue;
                visited[nr][nc] = true;
                q.add(new Point(nr,nc,curr.time + 1));
            }
        }

        return -1;
    }
}

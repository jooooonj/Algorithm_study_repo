package com.ll.programers.level2.p169199;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        s.solution(board);
    }
}


class Solution {
    static int[][] map;
    static boolean[][] visited;
    static int R;
    static int C;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,1,0,-1};
    static int result = -1;
    static class Point{
        int r;
        int c;
        int count;
        Point(int r, int c, int count){
            this.r=r;
            this.c=c;
            this.count = count;
        }
    }
    public int solution(String[] board) {
        R = board.length;
        C = board[0].length();
        map = new int[R][C];
        visited = new boolean[R][C];

        int sr = 0;
        int sc = 0;
        //-1은 장애물, 2는 자기 자신 5는 목적지
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(board[i].charAt(j) == 'D')
                    map[i][j] = -1;
                else if(board[i].charAt(j) == 'R'){
                    map[i][j] = 2;
                    sr = i;
                    sc = j;
                } else if(board[i].charAt(j) == 'G'){
                    map[i][j] = 5;
                }
            }
        }

        int answer = bfs(sr, sc);
        System.out.println(answer);
        return answer;
    }

    static int bfs(int sr, int sc){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sr,sc,0));

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;
            if(map[cr][cc] == 5)
                return curr.count;

            for(int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                //멈춰야 할때까지 계속 간다
                while(nr>=0 && nc>=0 && nr<R && nc<C && map[nr][nc]!=-1){
                    nr += dr[i];
                    nc += dc[i];
                }
                nr -= dr[i];
                nc -= dc[i];

                //기껏 찾았는데 이미 온 곳이다 ? 패스

                if(!visited[nr][nc]){
                    q.add(new Point(nr,nc,curr.count + 1));
                    visited[nr][nc] = true;
                }

            }
        }
        return -1;
    }

}


package com.ll.programers.level1.p250125;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main2 {
    public static void main(String[] args) {

    }
}

class Solution2 {
    public int solution(String[][] board, int h, int w) {
        int r = h;
        int c = w;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(r, c));

        String str = board[r][c];
        int count = 0;
        while(!q.isEmpty()){
            Point p = q.poll();

            for(int i = 0; i<4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length){
                    continue;
                }

                if(str.equals(board[nr][nc])){
                    count ++;
                }
            }
        }

        return count;

    }

    public class Point{
        int r;
        int c;

        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}


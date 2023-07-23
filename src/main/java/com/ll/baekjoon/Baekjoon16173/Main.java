package com.ll.baekjoon.Baekjoon16173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int N;
    static class Point{
        int r;
        int c;
        Point(int r, int c){
            this.r=r;
            this.c=c;
        }
    }
    static int calc(){
        Queue<Point> q = new LinkedList();
        q.add(new Point(0,0));

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;
            if(cr==N-1 && cc==N-1)
                return 1;

            int value = map[cr][cc];
            if(value==0)
                return -1;

            if(cr + value < N)
                q.add(new Point(cr + value, cc));
            if(cc + value < N)
                q.add(new Point(cr, cc+value));
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = calc();
        if(result==1)
            System.out.println("HaruHaru");
        else
            System.out.println("Hing");

//        for(int i=0; i<N; i++){
//            for(int j=0; j<N; j++){
//                System.out.print(map[i][j] +" ");
//            }
//            System.out.println();
//        }

    }
}


package com.ll.E.Elice4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
class Main {
    static int R;
    static int C;
    static Point house;
    static Point school;
    static int[][] map;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int min = Integer.MAX_VALUE;
    static int TIME = 0;
    static class Command{
        int w;
        int l;
        int num;

        Command(int w, int l, int num){
            this.w=w;
            this.l=l;
            this.num=num;
        }
    }

    static class Point{
        int r;
        int c;
        int pay;
        Point(int r, int c, int pay){
            this.r=r;
            this.c=c;
            this.pay=pay;
        }
    }

    static void bfs(int time){
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[R][C];
        q.add(house);

        while(!q.isEmpty()){
            Point curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;
            System.out.print(cr+" "+cc);
            System.out.println();

            if(cr==school.r && cc == school.c){
                if(min > curr.pay){
                    min = curr.pay;
                    TIME = time;
                }
            }

            for(int i=0; i<4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr<0 || nc<0 || nr>=R || nc>=C) continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;
                q.add(new Point(nr,nc,curr.pay + map[nr][nc]));
            }


        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        house = new Point(x1 -1, y1-1,0);

        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        school = new Point(x2-1, y2-1,0);

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<C; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int Q = Integer.parseInt(br.readLine());
        Command[] command = new Command[Q];
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            command[i] = new Command(w,l,num);
        }

        bfs(0);
        System.out.print(TIME+" "+min);
        for(int q= 0; q<Q; q++){
            Command curr = command[q];
            if(curr.w == 2){
                for(int i=0; i<C; i++){
                    map[curr.l - 1][i] += curr.num;
                    if(map[curr.l - 1][i] < 0){
                        map[curr.l - 1][i] = 0;
                    }
                }

            } else{
                for(int i=0; i<R; i++){
                    map[i][curr.l - 1] += curr.num;
                    if(map[i][curr.l - 1] < 0){
                        map[i][curr.l- 1] = 0;
                    }
                }
            }

            bfs(q+1);
            System.out.print(TIME+" "+min);
        }









    }
}
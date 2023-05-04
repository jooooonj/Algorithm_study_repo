package com.ll.삼성SW역량테스트기출.sw1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    static int[][] map;

    static int N;
    static int MIN = Integer.MAX_VALUE;

    static class Point implements Comparable<Point>{
        int r;
        int c;
        int time;
        Point(int r, int c, int time){
            this.r = r;
            this.c = c;
            this.time = time;
        }


        @Override
        public int compareTo(Point o) {
            return this.time - o.time;
        }
    }

    static void bfs(){
        PriorityQueue<Point> q = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        q.add(new Point(0,0, 0));
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Point curr = q.poll();
            int cr = curr.r;
            int cc = curr.c;

//            System.out.println(cr+", "+cc + ", "+ curr.time);
            //도착했으면 최소값 갱신
            if(cr==N-1 && cc==N-1){
                MIN = Math.min(curr.time, MIN);
            }

            for(int i=0; i<4; i++)  {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if(nr<0||nc<0||nr>=N||nc>=N) continue;
                if(visited[nr][nc]) continue;

                visited[nr][nc] = true;
                if(curr.time + map[nr][nc] >= MIN) continue;
                q.add(new Point(nr, nc, curr.time + map[nr][nc]));
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        //공병대는 (0,0) -> (N-1, N-1) 까지
        //0 인곳 복구 불가능
        //반복할 케이스 수
        final int CASE = Integer.parseInt(br.readLine());

        for(int ca = 0; ca<CASE; ca++ ){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }

            bfs();
            sb.append("#"+(ca+1)+" "+MIN+"\n");
            MIN = Integer.MAX_VALUE;
            map = null;
            N = 0;
//            System.out.println(Arrays.deepToString(map));
        }

        System.out.println(sb);
    }
}

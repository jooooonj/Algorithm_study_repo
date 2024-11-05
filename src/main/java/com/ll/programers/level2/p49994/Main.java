package com.ll.programers.level2.p49994;

public class Main {
}

class Solution {
    static int N;
    static int count;
    static int[][] map;
    static boolean[][][] visited; //방향까지 기록해야 한다.

    public int solution(String dirs) {
        N = 11;
        count = 0;
        map = new int[N][N];
        visited = new boolean[N][N][27];

        int cr = 5;
        int cc = 5;

        for(int i=0; i<dirs.length(); i++){
            char ch = dirs.charAt(i);

            int d = -1;
            int nr = cr;
            int nc = cc;
            if(ch == 'U'){
                nr--;
                d = 0;
            } else if(ch == 'D'){
                nr++;
                d = 1;
            } else if(ch == 'R'){
                nc++;
                d = 2;
            } else {
                nc--;
                d = 3;
            }

            if(nr<0 || nc<0 || nr>=N || nc>=N){ //범위를 벗어나면
                continue;
            }


            //범위를 벗어나지 않는 경우만 체크
            if(!visited[nr][nc][d]){
                count++;

                visited[nr][nc][d] = true;

                if(d == 0){
                    visited[cr][cc][1] = true;
                } else if (d==1){
                    visited[cr][cc][0] = true;
                } else if (d==2){
                    visited[cr][cc][3] = true;
                } else {
                    visited[cr][cc][2] = true;
                }
            }

            cr = nr;
            cc = nc;
        }

        return count;
    }
}
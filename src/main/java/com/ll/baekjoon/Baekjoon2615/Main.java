package com.ll.baekjoon.Baekjoon2615;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[] dr = {0, 0, 1, -1, 1, -1, -1, 1};
    static int[] dc = {1, -1, 0, 0, 1, -1, 1, -1};

    // r, c 순서대로 방향
    //0,1 // 0,-1 // 1,0 // -1,0 // 1,1 // -1,-1 // -1,1 // 1,-1 8방향
    // 우 : 0
    // 좌 : 1

    // 하 : 2
    // 상 : 3

    // 오른아래 : 4
    // 왼위 : 5

    // 왼아래 : 6
    // 오른위 : 7
    static int dfs(int r, int c, int point, int count, int d) {
        if (r < 0 || c < 0 || r >= 19 || c >= 19){
            return count - 1;
        }
        
        if (map[r][c] != point) {
            return count - 1;
        }


        return dfs(r + dr[d], c + dc[d], point, count + 1, d);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[19][19];
        for (int i = 0; i < 19; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 19; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int win = -1;
        int r=21;
        int c=21;
        boolean isSuccess = false;
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                int result1 = 1;
                int result2 = 1;
                int result3 = 1;
                int result4 = 1;
                if (map[i][j] != 0) {
                    result1 += dfs(i, j, map[i][j], 0, 0);
                    result1 += dfs(i, j, map[i][j], 0, 1);
                    result2 += dfs(i, j, map[i][j], 0, 2);
                    result2 += dfs(i, j, map[i][j], 0, 3);

                    result3 += dfs(i, j, map[i][j], 0, 4);
                    result3 += dfs(i, j, map[i][j], 0, 5);

                    result4 += dfs(i, j, map[i][j], 0, 6);
                    result4 += dfs(i, j, map[i][j], 0, 7);
                }

                if(result1==5 || result2==5 || result3==5 || result4==5){
                    win = map[i][j];
                    if(c > j+1){
                        r = i+1;
                        c = j+1;
                    } else if(c== j+1 ){
                        if(r > i+1)
                            r = i+1;
                    }
                    break;
                }

            }
        }

        if(win == -1)
            System.out.println(0);
        else{
            System.out.println(win);
            System.out.println(r+" "+c);
        }

    }
}

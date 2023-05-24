package com.ll.baekjoon.Baekjoon3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static char[][] map;
    static int[][] note;
    static int max = Integer.MIN_VALUE;
    static void findWeight(){
        note = new int[N+2][N+2];

        //가로
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(map[i][j]==map[i][j-1])
                    note[i][j] = note[i][j-1] + 1;
                else
                    note[i][j] = 1;
            }
        }
        findMax();
    }
    static void findHeight(){
        note = new int[N+2][N+2];

        //세로
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                if(map[j][i]==map[j-1][i])
                    note[j][i] = note[j-1][i] + 1;
                else
                    note[j][i] = 1;
            }
        }
        findMax();
    }
    static void findMax(){
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                max = Math.max(max, note[i][j]);
            }
        }
    }

    static void change(int r1, int c1, int r2, int c2){
        char tmp = map[r1][c1];
        map[r1][c1] = map[r2][c2];
        map[r2][c2] = tmp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new char[N+2][N+2];

        for(int i=1; i<N+1; i++){
            String str = br.readLine();
            for(int j=1; j<N+1; j++){
                map[i][j] = str.charAt(j-1);
            }
        }

        //가로
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N; j++){
                if(map[i][j] == map[i][j+1]) continue;

                change(i,j,i,j+1);
                findHeight();
                findWeight();
                change(i,j+1,i,j);
            }
        }

        for(int i=1; i<N+1; i++){
            for(int j=1; j<N; j++){
                if(map[j][i] == map[j+1][i]) continue;

                change(j,i,j+1,i);
                findHeight();
                findWeight();
                change(j+1,i,j,i);
            }
        }

        System.out.println(max);





    }

    static void print(){
        for(int i=0; i<N+2; i++){
            for(int j=0; j<N+2; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}

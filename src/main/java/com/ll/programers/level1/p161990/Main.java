package com.ll.programers.level1.p161990;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] test = {".#...", "..#..", "...#."};
        String[] test2 = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        Solution s = new Solution();
        int[] result = s.solution(test2);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    public int[] solution(String[] wallpaper) {
        int R = wallpaper.length;
        int C = wallpaper[0].length();
        int minR = R - 1;
        int minC = C - 1;
        int maxR = 0;
        int maxC = 0;

        char[][] map = new char[R][C];

        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] = wallpaper[i].charAt(j);
                if(map[i][j]=='#'){
                    if(minR > i)
                        minR = i;
                    if(minC > j)
                        minC = j;
                    if(maxR < i)
                        maxR = i;
                    if(maxC < j)
                        maxC = j;
                }
            }
        }

        int[] arr = {minR,minC,maxR + 1,maxC + 1};

        return arr;
    }
}

package com.ll.level0.p120875;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] test = {{1, 4}, {9, 2}, {3, 8}, {11, 6}};
        int result = s.solution(test);
        System.out.println(result);
    }
}

class Solution {
    public double findSlope(int[] dot1, int[] dot2) {
        // 기울기 구하는 공식 : (y2 - y1) / (x2 - x1)
        return (double)(dot2[1] - dot1[1]) / (dot2[0] - dot1[0]);
    }
    public int solution(int[][] dots) {
        int[][] note = new int[100][100];

        if(findSlope(dots[0], dots[1]) == findSlope(dots[2], dots[3]))
            return 1;
        if(findSlope(dots[0], dots[2]) == findSlope(dots[1], dots[3]))
            return 1;
        if(findSlope(dots[0], dots[3]) == findSlope(dots[1], dots[2]))
            return 1;
        return 0;

//        for(int i=0; i<3; i++){
//
//            for(int j=i+1; j<4; j++){
//                int x = Math.abs(dots[i][0] - dots[j][0]);
//                int y = Math.abs(dots[i][1] - dots[j][1]);
//
//                if(note[x][y] > 0){
//                    return 1;
//                }
//                note[x][y]++;
//            }
//        }
//        return 0;
    }
}

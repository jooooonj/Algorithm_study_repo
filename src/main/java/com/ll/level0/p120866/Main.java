package com.ll.level0.p120866;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 0, 0}};
        int result = s.solution(board);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int[][] board) {
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        int length = board.length;
        int[][] clone = new int[length][length];
        for(int i = 0; i < length; i++){ // 반복문 + ArrayCopy
            System.arraycopy(board[i], 0, clone[i], 0, clone[i].length);
        }

        int total = length * length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {

                if (board[i][j] == 1) {
                    for (int k = 0; k < 8; k++) {
                        int nr = i + dr[k];
                        int nc = j + dc[k];

                        if (nr >= 0 && nr <= length -1 && nc >= 0 && nc <= length -1) {
                            clone[nr][nc] = 1;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length ;j++) {
                if(clone[i][j] == 1){
                    total -- ;
                }
            }
        }

        return total;

    }
}
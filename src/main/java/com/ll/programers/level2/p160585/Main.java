package com.ll.programers.level2.p160585;

import java.util.Stack;

public class Main {
}

class Solution {
    public int solution(String[] board) {
        // 1. O >= X
        // 2. O 3빙고 -> O > X
        // 3. X 3빙고 -> O == X

        // 3빙고 경우의수
        // - 가로로 3개
        // - 세로로 3개
        // - 00, 11, 22 or 02, 11, 20

        char[][] chArr = new char[3][3];


        int oCount = 0;
        int xCount = 0;
        for(int i=0; i<board.length; i++){
            String b = board[i];

            for(int j=0; j<b.length(); j++){
                char ch = b.charAt(j);

                chArr[i][j] = ch;
                if(ch == 'O'){
                    oCount++;
                } else if (ch == 'X'){
                    xCount++;
                }
            }
        }

        if(xCount > oCount) return 0;
        if(oCount - xCount > 1) return 0;

        if(chArr[0][0] == 'O' && chArr[1][1] == 'O' && chArr[2][2] == 'O' ||
                chArr[0][2] == 'O' && chArr[1][1] == 'O' && chArr[2][0] == 'O'){
            if(oCount == xCount) return 0;
        } else if(chArr[0][0] == 'X' && chArr[1][1] == 'X' && chArr[2][2] == 'X' ||
                chArr[0][2] == 'X' && chArr[1][1] == 'X' && chArr[2][0] == 'X'){
            if(oCount > xCount) return 0;
        }

        //가로검사
        for(int i=0; i<3; i++){
            boolean oFinish = true;
            boolean xFinish = true;

            for(int j=0; j<3; j++){
                if(chArr[i][j] != 'O'){
                    oFinish = false;
                }

                if(chArr[i][j] != 'X'){
                    xFinish = false;
                }
            }

            if(oFinish && oCount == xCount) {
                return 0;
            }

            if(xFinish && oCount > xCount){
                return 0;
            }
        }

        // 세로 검사
        for(int i=0; i<3; i++){
            boolean oFinish = true;
            boolean xFinish = true;

            for(int j=0; j<3; j++){
                if(chArr[j][i] != 'O'){
                    oFinish = false;
                }

                if(chArr[j][i] != 'X'){
                    xFinish = false;
                }
            }

            if(oFinish && oCount == xCount) {
                return 0;
            }

            if(xFinish && oCount > xCount){
                return 0;
            }
        }

        return 1;

    }
}

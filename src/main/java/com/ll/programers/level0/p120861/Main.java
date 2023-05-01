package com.ll.programers.level0.p120861;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

    }
}

class Solution {

    public int[] solution(String[] keyinput, int[] board) {
        int left = -1 * (board[0] / 2);
        int right = (board[0] / 2);

        int up = (board[1] / 2) ;
        int down = -1 * (board[1] / 2);

        int[] result = new int[2];

        int x = 0;
        int y = 0;

        for(String cmd : keyinput){
            if(cmd.equals("left")){
                if(x != left)
                    x--;
            } else if(cmd.equals("right")){
                if(x != right)
                    x++;
            } else if(cmd.equals("up")){
                if(y != up)
                    y++;
            } else if(cmd.equals("down")){
                if(y != down)
                    y--;
            }
        }

        result[0] = x;
        result[1] = y;
        return result;
    }
}

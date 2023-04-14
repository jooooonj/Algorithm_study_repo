package com.ll.level1.p178871;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = s.solution(players, callings);

        System.out.print(Arrays.toString(result));
    }
}
class Solution {
    public String[] solution(String[] players, String[] callings) {
        for(int i=0; i<callings.length; i++){
            String call = callings[i];

            for(int j=1; j<players.length; j++){
                if(call.equals(players[j])){
                    String tmp = players[j-1];
                    players[j-1] = players[j];
                    players[j] = tmp;
                }
            }
        }
        return players;
    }
}

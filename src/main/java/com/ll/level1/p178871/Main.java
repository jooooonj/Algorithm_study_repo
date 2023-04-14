package com.ll.level1.p178871;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

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
    public void swap(String[] arr, int a, int b) {
        String tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<players.length; i++){
            map.put(players[i], i); //o(1)
        }

        for(int i=0; i<callings.length; i++){
            int index = map.get(callings[i]);

            String name = players[index];
            String front = players[index - 1];
            map.put(name, index - 1);
            map.put(front, index);

            swap(players, index, index - 1);
        }

        return players;
    }
}

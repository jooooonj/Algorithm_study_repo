package com.ll.programers.level1.p138477;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] score = {10, 100, 20, 150, 1, 100, 200};
        int k = 3;
        s.solution(k, score);
    }
}

class Solution {
    public int[] solution(int k, int[] score) {
        List<Integer> list = new ArrayList<>();

        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            int s = score[i];

            list.add(s);
            Collections.sort(list);
            if(list.size() > k){

               list.remove(0);
            }

            answer[i] = list.get(0);
        }

        return answer;
    }
}
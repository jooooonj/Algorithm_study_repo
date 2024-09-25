package com.ll.programers.level1.p42748;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] command = commands[i];

            int startIndex = command[0] - 1;
            int endIndex = command[1] - 1;
            int index = command[2] - 1;

            List<Integer> list = new ArrayList<>();

            for(int j=startIndex; j<=endIndex; j++){
                list.add(array[j]);
            }
            Collections.sort(list);

            answer[i] = list.get(index);
        }

        return answer;
    }
}
package com.ll.programers.level2.p42586;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        Solution s = new Solution();
        s.solution(progresses, speeds);
    }
}

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> counts = new ArrayList<>();

        //각 작업이 얼마나 걸리는지 기록
        int[] days = new int[progresses.length];
        for(int i=0; i<progresses.length; i++){
            if((100-progresses[i]) % speeds[i] == 0)
                days[i] = (100-progresses[i]) / speeds[i];
            else
                days[i] = (100-progresses[i]) / speeds[i] + 1;
        }

        for(int i=0; i<days.length; i++){
            int count = 1;

            int j = i+1;
            while(j<days.length){
                if(days[i] < days[j]) break;
                count++;
                j++;
            }
            counts.add(count);
            i = j - 1;
        }

        Integer[] tmp = counts.toArray(new Integer[counts.size()]);
        int[] result = new int[tmp.length];
        for(int i=0; i<tmp.length; i++){
            result[i] = tmp[i];
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}

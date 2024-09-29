package com.ll.programers.level1.p176963;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
}

class Solution2 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String, Integer> scores = new HashMap<String, Integer>();

        for(int i=0; i < name.length; i++){
            scores.put(name[i], yearning[i]);
        }

        int[] answer = new int[photo.length];

        int index = 0;
        for(String[] pt : photo){
            int total = 0;
            for(int i=0; i<pt.length; i++){
                String person = pt[i];

                total += scores.getOrDefault(person, 0);
            }

            answer[index++] = total;
        }

        return answer;
    }
}

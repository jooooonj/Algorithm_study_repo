package com.ll.programers.level2.p152996;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
}

class Solution {
    public long solution(int[] weights) {

        //오름차순 정렬 -> 뒤에가 무조건 더 큼 (1:1, 1:2, 2:3, 3:4) 경우만 생각하면 된다.
        Arrays.sort(weights);

        Map<Double, Integer> map = new HashMap<>();
        long total = 0;
        for(int i=0; i<weights.length; i++){
            int weight = weights[i];

            double  a = weight * 1.0;
            double  b = (weight * 1.0) / 2.0;
            double  c = (weight * 2.0) / 3.0;
            double  d = (weight * 3.0) / 4.0;

            if(map.containsKey(a)) total += map.get(a);
            if(map.containsKey(b)) total += map.get(b);
            if(map.containsKey(c)) total += map.get(c);
            if(map.containsKey(d)) total += map.get(d);
            map.put(weight*1.0, map.getOrDefault(weight*1.0, 0) + 1);
        }

        return total;
    }
}
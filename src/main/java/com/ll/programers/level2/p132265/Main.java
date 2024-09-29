package com.ll.programers.level2.p132265;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> map1 = new HashMap<Integer,Integer>();
        Map<Integer, Integer> map2 = new HashMap<Integer,Integer>();

        for(int n : topping){
            Integer value = map1.getOrDefault(n, 0);
            map1.put(n, value+1);
        }


        for(int n : topping){
            Integer value = map1.getOrDefault(n, 1);
            if(value - 1 == 0){
                map1.remove(n);
            } else {
                map1.put(n, value - 1);
            }

            map2.put(n, 1);

            if(map1.size() == map2.size()){
                answer++;
            }
        }
        return answer;
    }
}
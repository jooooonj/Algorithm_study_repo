package com.ll.programers.level1.p42576;

import java.util.HashMap;
import java.util.Map;

public class Main2 {
    public static void main(String[] args) {

    }
}

class Solutions2 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<String, Integer>();

        for(String str : completion){
            Integer value = map.get(str);
            if(value == null){
                map.put(str, 1);
            } else if(value > 0){
                map.put(str, value + 1);
            }

        }

        for(String str : participant){
            Integer value = map.get(str);
            if(value == null){
                return str;
            } else if (value > 0){
                if(value - 1 == 0){
                    map.remove(str);
                } else {
                    map.put(str, value - 1);
                }
            }
        }

        return "";
    }
}

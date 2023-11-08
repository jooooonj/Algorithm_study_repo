package com.ll.programers.level1.p131128;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

}

class Solution {
    public String solution(String X, String Y) {
        int[] x = new int[10]; //0~9까지의 수
        int[] y = new int[10];

        for(int i=0; i<X.length(); i++){
            char ch = X.charAt(i);
            x[ch-'0']++;
        }

        for(int i=0; i<Y.length(); i++){
            char ch = Y.charAt(i);
            y[ch-'0']++;
        }

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<=9; i++){
            if(x[i]>0 && y[i]>0){
                int pair = Math.min(x[i], y[i]);
                for(int j=0; j<pair; j++){
                    list.add(i);
                }
            }
        }

        if(list.size() == 0)
            return String.valueOf(-1);


        Collections.sort(list, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        for(int num : list){
            sb.append(num);
        }

        if(sb.toString().charAt(0)=='0')
            return "0";

        return sb.toString();
    }
}
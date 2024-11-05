package com.ll.programers.level2.p142085;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
}

class Solution {
    public int solution(int n, int k, int[] enemy) {

        // 정렬하고, 앞에서 k개만큼 미리 뽑아놓고,
        // 만약 그 숫자면 무적권 사용

        Integer[] tmp = new Integer[enemy.length];
        for(int i=0; i<enemy.length; i++){
            tmp[i] = enemy[i];
        }

        Arrays.sort(tmp, (o1, o2) -> {
            return o2 - o1;
        });
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<k; i++){
            list.add(tmp[i]);
        }

        int count = 0;
        for(int i=0; i<enemy.length; i++){
            if(list.contains(enemy[i]) && k>0){
                list.remove(enemy[i]);
                k--;
                count++;
                continue;
            }

            if(n - enemy[i] < 0){
                break;
            }

            count++;
            n -= enemy[i];
        }

        return count;
    }
}
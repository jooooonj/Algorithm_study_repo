package com.ll.programers.level2.p131130;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
}

class Solution {
    List<Integer> list;
    boolean[] visited;
    public int solution(int[] cards) {
        // 열린 카드 수를 담을 것이다.
        list = new ArrayList<>();

        // 이미 연 카드를 기록할 것이다.
        visited = new boolean[cards.length];

        for(int i=0; i<cards.length; i++){
            if(!visited[i]){
                dfs(cards, 0, i);
            }
        }

        Collections.sort(list);

        if(list.size() < 2){
            return 0;
        }
        return list.get(list.size() -1) * list.get(list.size() -2);
    }

    public void dfs(int[] cards, int depth, int index){
        if(visited[index]){
            list.add(depth);
            return;
        }

        if(depth == cards.length){
            return;
        }

        visited[index] = true;
        dfs(cards, depth+1, cards[index]-1);
    }
}

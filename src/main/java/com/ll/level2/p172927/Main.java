package com.ll.level2.p172927;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};
        Solution s = new Solution();

        s.solution(picks, minerals);

    }
}

class Solution {
    int mineralPart;
    String minerals[];
    boolean[] visited;
    int[] picks;
    int min = Integer.MAX_VALUE;
    int stamina = 0;

    public int solution(int[] pickss, String[] minerals) {
        //광석 저장
        this.minerals = minerals;
        mineralPart = (minerals.length + 4) / 5;

        int N = 0;
        for(int n : pickss){
            N += n;
        }

        picks = new int[N];
        visited = new boolean[N];

        int index = 0;
        for(int i=0; i<pickss.length; i++){
            int num = pickss[i];

            for(int j=0; j<num; j++){
                picks[index++] = i + 1;
            }
        }

        backTracking(new ArrayList<>());

        System.out.println(min);
        return min;

    }

    int search(int pick, int part) {

        if(part > mineralPart)
            return 0;

        int stamina = 0;

        int index = (part-1) * 5;

        for (int j = index; j < index + 5 && j < minerals.length; j++) {
            stamina += calcStamina(pick, minerals[j]);
        }

        return stamina;
    }

    void backTracking(List<Integer> list) {
        if (!list.isEmpty() && list.get(list.size() - 1) == picks.length - 1) {
            if(stamina < min){
                min = stamina;
            }
            return;
        }



        for (int i = 0; i < picks.length; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            list.add(i);
            int s = search(picks[i], list.size());
            stamina += s;
            if(stamina < min) backTracking(list);

            stamina -= s;
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }

    int calcStamina(int pick, String mineral) {

        if (pick == 2)
            if (mineral.equals("diamond")) return 5;

        if (pick == 3) {
            if (mineral.equals("diamond")) return 25;
            if (mineral.equals("iron")) return 5;
        }

        return 1;
    }
}

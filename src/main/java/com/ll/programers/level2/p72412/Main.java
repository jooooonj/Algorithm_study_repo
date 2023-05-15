package com.ll.programers.level2.p72412;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        s.solution(info, query);
    }
}

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> infos = new HashMap<>();
        int[] result = new int[query.length];
        for(String str : info){
            String[] split = str.split(" ");

            makeKey(split, infos, 0, "");
        }

        for(String key : infos.keySet())
            Collections.sort(infos.get(key));

        for(int i =0; i<query.length; i++){
            String q = query[i];
            String[] split = q.split(" ");
            q = split[0]+split[2]+split[4]+split[6];

            if(!infos.containsKey(q))
                result[i] = 0;
            else{
                List<Integer> list = infos.get(q);
                int goal = Integer.parseInt(split[7]);

                int left = 0;
                int right = list.size() - 1;

                while(left<=right){
                    int m = (left+right) / 2;

                    int value = list.get(m);
                    if(value >= goal)
                        right = m-1;
                    else
                        left = m+1;
                }

                result[i] = list.size() - left;
            }
        }

        return result;
    }

    public void makeKey(String[] split, Map<String, List<Integer>> infos, int index, String note) {
        if (index == 4) {
            note = note.trim();
            if (infos.containsKey(note))
                infos.get(note).add(Integer.parseInt(split[4]));
            else {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(split[4]));
                infos.put(note, list);
            }
            return;
        }

        makeKey(split, infos, index + 1, note + "-");
        makeKey(split, infos, index + 1, note  + split[index]);
    }
}


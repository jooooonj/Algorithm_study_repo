package com.ll.programers.level3.p12946;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] relationships = {{1, 2}, {2, 3}, {2, 6}, {3, 4}, {4, 5}};
        int target = 1;
        int limit = 2;
        int result = s.solution(relationships, target, limit);
        System.out.println(result);
    }
}

class Solution {
    static int totalScore = 0;
    static List<Integer> duplicate = new ArrayList<>();
    static int newFriends = 0;
    static Map<Integer, List<Integer>> friendMap = new HashMap<>();
    static boolean[][] check;

    public int solution(int[][] relationships, int target, int limit) {
        check = new boolean[101][101];
        duplicate.add(target);
        for (int[] relationship : relationships) {
            int p1 = relationship[0];
            int p2 = relationship[1];

            if(!friendMap.containsKey(p1))
                friendMap.put(p1, new ArrayList<>());
            if(!friendMap.containsKey(p2))
                friendMap.put(p2, new ArrayList<>());
            if(!check[p1][p2] && !check[p2][p1]){
                friendMap.get(p1).add(p2);
                friendMap.get(p2).add(p1);
                check[p1][p2] = true;
                check[p2][p1] = true;
            }
        }

        for(int i=0; i<friendMap.get(target).size(); i++){
            Integer tmp = friendMap.get(target).get(i);
            duplicate.add(tmp);
            friendMap.get(tmp).remove(target);
            totalScore+=5;
        }

        calc(friendMap.get(target), 2, limit);
        return totalScore + newFriends;
    }

    public void calc(List<Integer> friends, int limit, int realLimit) {
        if (limit > realLimit)
            return;

        for (int friend : friends) { //내친구

            List<Integer> friendsFriends = friendMap.get(friend); //친구의 친구
            for(int f : friendsFriends){ //친구의 친구가

                if (duplicate.contains(f)) //이미 내친구면 패스
                    continue;

                totalScore+=10; //아니면 점수부여
                duplicate.add(friend); //친구에 추가
                friendMap.get(f).remove(new Integer(friend));
                friendMap.get(friend).remove(f);
                newFriends++;
                calc(friendsFriends, limit+1, realLimit); //친구의 친구의 친구 검사 시작
            }
        }
    }
}
package com.ll.programers.level1.p42840;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] answers = {1,2,3,4,5};
        Solution s = new Solution();
        s.solution(answers);
    }
}

class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};

        int[] rank = new int[3];

        //1번 답부터 뽑아서 각 사람이 찍은 답과 비교
        for(int i=0; i<answers.length; i++){
            int answer = answers[i];

            if(one[i%one.length] == answer) rank[0]++;
            if(two[i%two.length] == answer) rank[1]++;
            if(three[i%three.length] == answer) rank[2]++;
        }

        int max = Math.max(rank[2], Math.max(rank[0], rank[1]));

        List<Integer> answer = new ArrayList<>();

        for(int i=0; i<3; i++){
            if(max==rank[i]){
                answer.add(i);
            }
        }

        int[] result = new int[answer.size()];

        for(int i=0; i<answer.size(); i++){
            result[i] = answer.get(i) + 1;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
package com.ll.programers.level2.p49993;

import java.util.Arrays;

public class Main {
}

class Solution {
    static int count = 0;
    public int solution(String skill, String[] skill_trees) {
        boolean[] visited = new boolean[26];
        for(String skillTree : skill_trees){

            boolean pass = true;
            Arrays.fill(visited, false);
            for(int i=0; i<skillTree.length(); i++){
                char ch = skillTree.charAt(i);

                int index = skill.indexOf(ch);
                if(index != -1) {
                    if(index>0 && !visited[skill.charAt(index-1) -'A']) {
                        pass = false;
                        break;
                    }

                    visited[skill.charAt(index)-'A'] = true;
                }
            }

            if(pass) count++;
        }

        return count;
    }
}

package com.ll.programers.level0.p120876;


public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] lines = {{0, 1}, {2, 5}, {3, 9}};
        int result = s.solution(lines);
        System.out.println(result);
    }
}

class Solution {
    public int solution(int[][] lines) {
        int[] line = new int[201];

        for(int i=0; i<lines.length; i++){

            for(int j = lines[i][0]; j<lines[i][1]; j++){
                line[j+100]++;
            }
        }
        int count = 0;
        
        for(int i=0; i<201; i++){
            if(line[i] > 1)
                count++;
        }

        return count;
    }
}
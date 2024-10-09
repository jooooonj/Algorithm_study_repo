package com.ll.programers.level2.p43165;

public class Main {
}

class Solution {
    static int L;
    static int count = 0;
    public int solution(int[] numbers, int target) {
        L = numbers.length;


        // 완전 탐색
        dfs(numbers, 0, 0, target);

        return count;
    }

    public void dfs(int[] numbers, int sum, int depth, int target){
        if(depth >= L){
            if(sum == target){
                count++;
            }

            return;
        }

        dfs(numbers, sum + numbers[depth], depth+1, target);
        dfs(numbers, sum - numbers[depth], depth+1, target);
    }
}

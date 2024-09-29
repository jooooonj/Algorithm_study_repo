package com.ll.programers.level2.p42839;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String numbers = "17";
        s.solution(numbers);
    }
}
class Solution {
    static boolean[] isVisited;
    static Set<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        isVisited = new boolean[numbers.length()];
        dfs("", numbers, 0);

        int answer = 0;
        for(Integer n : set){
            if(isPrime(n)){
                answer++;
            }
        }

        return answer;

    }

    public void dfs(String str, String numbers, int n){
        if(n == numbers.length()){
            return;
        }

        for(int i = 0 ; i<numbers.length(); i++){
            if(isVisited[i]) continue;

            isVisited[i] = true;
            set.add(Integer.parseInt(str + numbers.charAt(i)));
            dfs(str + numbers.charAt(i), numbers, n+1);
            isVisited[i] = false;
        }
    }

    public boolean isPrime(int n){
        if(n<2) return false;

        for(int i=2; i*i<=n; i++){
            if(n % i == 0){
                return false;
            }
        }

        return true;
    }
}
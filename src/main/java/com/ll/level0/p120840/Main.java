package com.ll.level0.p120840;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution(5, 3);
        System.out.println(result);
    }
}
class Solution {
    static boolean[] visited;
    static int N;
    static int M;
    static int result = 0;
    public int solution(int balls, int share) {
        N = balls;
        M = share;
        visited = new boolean[N];

        dfs(0, 0);

        return result;
    }

    static public void dfs(int count, int index){
        if(count == M){
            result++;
            return;
        }

        for(int i=index; i<N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            dfs(count + 1, i + 1);
            visited[i] = false;
        }
    }
}

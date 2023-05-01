package com.ll.programers.level2.p12952;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(4);
    }
}

class Solution {
    static int N;
    static boolean[] visited_1;
    static boolean[] visited_2;
    static boolean[] visited_3;
    static boolean[] visited_4;
    static int[][] map;
    static int count = 0;


    public int solution(int n) {
        N = n;
        visited_1 = new boolean[N];
        visited_2 = new boolean[N];
        visited_3 = new boolean[N*2 -1];
        visited_4 = new boolean[N*2 -1];
        map = new int[N][N];
        solve(0);

        System.out.println(count);
        return count;
    }


    public void solve(int n){
        if(n==N){
            count++;

            return;
        }

        for(int i=0; i<N; i++){

            if(!check(n,i)){
                fillTrueOrFalse(n,i,true);
                solve(n+1);
                fillTrueOrFalse(n,i,false);
            }
        }
    }

    private static void printMap() {
        for(int i=0; i<N ;i++){
            for(int j=0; j<N; j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void fillTrueOrFalse(int i, int j, boolean tf) {
        visited_1[i] = tf;
        visited_2[j] = tf;
        visited_3[i + j] = tf;
        visited_4[j - i + (N-1)] = tf;
    }

    private static boolean check(int i, int j) {

        if(visited_1[i])return true;
        if(visited_2[j])return true;
        if(visited_3[i+j])return true;
        if(visited_4[j - i + (N-1)])return true;

        return false;
    }
}

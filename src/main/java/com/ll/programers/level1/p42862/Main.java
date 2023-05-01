package com.ll.programers.level1.p42862;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int[] lost = {2, 4};
        int[] reverse = {3};
        s.solution(n, lost, reverse);
    }
}

class Solution {
    static int N;
    static int MAX = Integer.MIN_VALUE;
    static int[] students;

    public int solution(int n, int[] lost, int[] reserve) {
        N = n;
        students = new int[n + 2];

        //체육복 다 하나씩 있는데 잃어버린 학생들은 한개 줄이고, 여유분 있는 학생은 한개 늘린다.
        Arrays.fill(students, 1);
        for (int o : lost)
            students[o]--;
        for (int o : reserve)
            students[o]++;

        for(int i=1; i<=N; i++){
            if(students[i] == 0){
                if(students[i - 1] == 2){
                       students[i -1]--;
                       students[i]++;
                } else if(students[i + 1] == 2){
                    students[i + 1]--;
                    students[i]++;
                }
            }
        }
        int count = 0;
        for(int i=1; i<=N; i++){
            if(students[i] >= 1)
                count++;
        }
        System.out.println(count);
        return count;
    }
}


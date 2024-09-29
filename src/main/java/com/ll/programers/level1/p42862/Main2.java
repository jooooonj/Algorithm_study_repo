package com.ll.programers.level1.p42862;

import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) {

    }
}

class Solution2 {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] people = new int[n + 2];

        Arrays.fill(people, 1);

        for(int index : lost){
            people[index]--;
        }
        for(int index : reserve){
            people[index]++;
        }

        int count = 0;
        for(int i=1; i<=n; i++){
            if(people[i] > 0){
                count++;
            } else {
                if(people[i-1] > 1){
                    count++;
                    people[i-1]--;
                } else if (people[i+1] > 1){
                    count++;
                    people[i+1]--;
                }
            }
        }

        return count;
    }
}

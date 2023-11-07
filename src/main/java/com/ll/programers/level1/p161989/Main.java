package com.ll.programers.level1.p161989;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int n, int m, int[] section) {
        int count = 1;
        int s = section[0];
        int e = s + m - 1;

        for(int i : section){
            if(i > e) {
                s = i;
                e = s + m - 1;
                count++;
            }
        }

        return count;
    }
}

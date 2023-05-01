package com.ll.programers.level0.p120889;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] sides) {
        int index = -1;
        int max = -1;

        if(sides[0] > sides[1]){
            index = 0;
            max = sides[0];
        } else {
            index = 1;
            max = sides[1];
        }

        if(sides[index] < sides[2]){
            index = 2;
            max = sides[2];
        }
        int sum = 0;
        for(int i=0; i<3; i++){
            if(i==index)
                continue;
            sum += sides[i];
        }
        if(max < sum)
            return 1;
        else
            return 2;
    }
}

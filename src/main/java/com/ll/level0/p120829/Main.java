package com.ll.level0.p120829;

public class Main {
    public static void main(String[] args) {

    }
}


class Solution {
    public int solution(int angle) {
        int answer = 0;
        if(angle > 0 && angle < 90){
            answer =1;
        } else if(angle == 90){
            answer = 2;
        } else if(angle <180){
            answer = 3;
        } else if(angle ==180){
            answer = 4;
        }
        return answer;
    }
}
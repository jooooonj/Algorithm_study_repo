package com.ll.programers.level2.p42842;

public class Main {
}

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        for(int c=3; c<=total; c++){ //c는 세로
            int r = total / c; //r은 가로

            if(r < 3 || r < c){
                continue;
            }

            if((r-2) * (c-2) == yellow){
                answer[0] = r;
                answer[1] = c;
                break;
            }
        }

        return answer;
    }
}

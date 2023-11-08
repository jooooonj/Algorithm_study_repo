package com.ll.programers.level1.p77484;

public class Main {
}

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] result = new int[2]; //최고순위, 최저순위

        int count = 0; //맞은 개수
        int zeroCount = 0;
        for(int i=0; i<lottos.length; i++){
            int num = lottos[i];
            if(num == 0) {
                zeroCount++; //0의 개수 ++
                continue;
            }

            for(int j=0; j<win_nums.length; j++){
                if(num == win_nums[j]) count++; //맞은 개수 ++
            }
        }

        if(count < 2) result[1] = 6; //2개 이하 맞았으면 최저
        else if(count == 2) result[1] = 5;
        else if(count == 3) result[1] = 4;
        else if(count == 4) result[1] = 3;
        else if(count == 5) result[1] = 2;
        else if(count == 6) result[1] = 1;

        if(count + zeroCount < 2) result[0] = 6;
        else if(count + zeroCount == 2) result[0] = 5;
        else if(count + zeroCount == 3) result[0] = 4;
        else if(count + zeroCount == 4) result[0] = 3;
        else if(count + zeroCount == 5) result[0] = 2;
        else if(count + zeroCount == 6) result[0] = 1;

        return result;
    }
}

package com.ll.programers.level2.p148653;

public class Main {
}

class Solution {
    public int solution(int storey) {

        int count = 0;
        while(storey > 0){
            int num = storey % 10;
            storey /= 10;

            if(num > 5){
                count += (10 - num);
                storey += 1;
            } else if(num < 5){
                count += num;
            } else { //같은 경우

                if(storey % 10 >= 5){
                    count += (10 - num);
                    storey += 1;
                } else {
                    count += num;
                }
            }
        }
        return count;
    }
}

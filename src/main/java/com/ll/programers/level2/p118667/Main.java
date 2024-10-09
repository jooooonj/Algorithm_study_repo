package com.ll.programers.level2.p118667;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
}

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        long sum1 = 0; //q1의 합
        long sum2 = 0; //q2의 합
        for(int i=0; i<queue1.length; i++){
            q1.add(queue1[i]);
            sum1 += queue1[i];

            q2.add(queue2[i]);
            sum2 += queue2[i];
        }

        int count = 0; //반복횟수 (poll, insert)

        boolean isSuccess = false;
        while(!q1.isEmpty() && !q2.isEmpty()
                && count <= queue1.length * 2 * 1000){ //시간복잡도 안넘는만큼 거의 최대로 곱함
            if(sum1 == sum2){
                isSuccess = true;
                break;
            }

            if(sum1 > sum2){
                int poll = q1.poll();
                sum1 -= poll;

                q2.add(poll);
                sum2 += poll;
            } else {
                int poll = q2.poll();
                sum2 -= poll;

                q1.add(poll);
                sum1 += poll;
            }

            count++;
        }

        return isSuccess ? count : -1;
    }
}

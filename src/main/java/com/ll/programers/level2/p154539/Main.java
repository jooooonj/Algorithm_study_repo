package com.ll.programers.level2.p154539;

import java.util.Stack;

public class Main {
}

class Solution {
    public int[] solution(int[] numbers) {
        // 1,000,000 완전탐색 불가 for문 두 번 불가능
        int[] answer = new int[numbers.length];

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<numbers.length; i++){
            while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]){
                answer[stack.peek()] = numbers[i];
                stack.pop();
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int pop = stack.pop();
            answer[pop] = -1;
        }

        return answer;
    }
}

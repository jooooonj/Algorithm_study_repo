package com.ll.programers.level2.p42584;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int[] prices) {
        Stack<Integer> stack = new Stack<>();

        int[] answer = new int[prices.length];

        for(int i=0; i<prices.length; i++){
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int pop = stack.pop();
            answer[pop] = prices.length - pop -1;
        }

        return answer;
    }
}

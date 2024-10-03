package com.ll.programers.level2.p42586;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main2 {
}

class for문 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        int[] days = new int[speeds.length];
        for(int i=0; i<speeds.length; i++){
            days[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0){
                days[i] += 1;
            }
        }

        int count = 1;
        int current = days[0];

        for(int i=1; i<days.length; i++){
            if(current >= days[i]){
                count++;
            } else {
                current = days[i];
                list.add(count);
                count = 1;
            }
        }

        list.add(count);

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}

class Queue {
    public int[] solution(int[] progresses, int[] speeds) {

        Stack<Integer> stack = new Stack<>();

        for(int i=speeds.length -1 ; i>=0; i--){
            int tmp = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] > 0){
                tmp += 1;
            }

            stack.push(tmp);
        }

        List<Integer> list = new ArrayList<>();
        int current = stack.pop();
        int count = 1;
        while(!stack.isEmpty()){
            if(current >= stack.peek()){
                stack.pop();
                count++;
            } else {
                current = stack.pop();
                list.add(count);
                count = 1;
            }
        }

        list.add(count);

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}
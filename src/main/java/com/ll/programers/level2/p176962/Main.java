package com.ll.programers.level2.p176962;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {
}

class Solution {
    static List<Work> workList;
    static Stack<Work> stack;
    static String[] answers;
    public String[] solution(String[][] plans) {
        // 1. 시작 순서대로 정렬
        // 2. 과제 끝시간과 다음 과제 시작시간 비교해서 남은 시간 계산해서 stack에 적재
        // 3. 과제 끝나면 배열에 적재

        workList = new ArrayList<>();
        answers = new String[plans.length];
        stack = new Stack<>();
        int index = 0;

        for(String[] plan : plans){
            String name = plan[0];
            int startH = Integer.parseInt(plan[1].split(":")[0]);
            int startM = Integer.parseInt(plan[1].split(":")[1]);
            int runTime = Integer.parseInt(plan[2]);

            workList.add(new Work(name, startH * 60 + startM, runTime));
        }

        Collections.sort(workList, (o1, o2) -> {
            return o1.startTime - o2.startTime;
        });

        int currentTime = 0;
        for(int i=0; i<workList.size(); i++){
            if(i == workList.size() - 1){
                answers[index++] = workList.get(i).name;
                break;
            }

            Work work = workList.get(i);
            Work nextWork = workList.get(i+1);

            int endTime = work.startTime + work.runTime;
            currentTime = endTime;
            if(endTime > nextWork.startTime){
                stack.push(new Work(work.name, work.startTime, endTime - nextWork.startTime)); // 다 못한 만큼 넣어놓기
            } else if (endTime == nextWork.startTime){ //딱 일치하면 다 한거고 다음으로 넘어가면 된다.
                answers[index++] = work.name;
            } else { // 시간이 남았을 경우
                answers[index++] = work.name;
                while(!stack.isEmpty()){
                    Work remainWork = stack.pop();

                    if(currentTime + remainWork.runTime <= nextWork.startTime){ // 꺼낸 작업이 다음 작업 시작 전까지 끝낼 수 있다면 끝낸다.
                        answers[index++] = remainWork.name;
                        currentTime += remainWork.runTime;
                    } else { // 못 끝낸다면
                        stack.push(new Work(remainWork.name, remainWork.startTime,  remainWork.runTime - (nextWork.startTime - currentTime)));
                        break;
                    }
                }
            }
        }

        while(!stack.isEmpty()){
            Work remainWork = stack.pop();
            answers[index++] = remainWork.name;
        }

        return answers;
    }

    public class Work{
        String name;
        int startTime;
        int runTime;

        public Work(String name, int startTime, int runTime){
            this.name = name;
            this.startTime = startTime;
            this.runTime = runTime; //총 해야 하는 시간
        }
    }
}

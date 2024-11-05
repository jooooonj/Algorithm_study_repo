package com.ll.netmarble;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] costs = {4,2,0,1,0};
        int[] value = s.solution(costs);
        System.out.println("value : " + Arrays.toString(value));
    }

}

class Solution {
    static Map<Integer, Integer> map;
    static List<int[]> answers;
    static int N;
    public int[] solution(int[] costs) {
        map = new HashMap<>();
        N = costs.length;
        answers = new ArrayList<>();

        int[] arr = new int[N];
        boolean[] visited = new boolean[N+1];
        dfs(0, arr, visited, costs);

//        int[] v = {1,4,5,2,3};
//        int[] value = active(v);
        return answers.get(0);
    }

    public void dfs(int index, int[] arr, boolean[] visited, int[] costs){
        if(index == N){
            int[] value = active(arr);
            boolean isTrue = true;
            for(int i=0; i<costs.length; i++){
                if(costs[i] != value[i]){
                    isTrue = false;
                    break;
                }
            }
            if(isTrue){
                answers.add(arr.clone());
            }

            return;
        }

        for(int i=1; i<=N; i++){
            if(visited[i]) continue;
            visited[i] = true;
            arr[index] = i;
            dfs(index+1, arr, visited, costs);
            visited[i] = false;
        }
    }

    public int[] active(int[] costs){ // 5,4,3,2,1
        int[] arr = new int[N];
        int index = 0;
        int left = 0;
        int right = 1;
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        //일단 스택에 넣기
        for(int cost : costs){
            stack1.push(cost);
            map.put(cost, left); //0은 왼쪽, 1은 오른쪽으로 가정
        }

        int target = 1;

        int cost = 0;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            if(stack1.size() > 0 && stack1.peek() == target){
                stack1.pop();
                target++;
                arr[index++] = cost;
                cost = 0;
            } else if(stack2.size() > 0 && stack2.peek() == target){
                stack2.pop();
                target++;
                arr[index++] = cost;
                cost = 0;
            } else {
                int value = map.get(target);
                if(value == left){
                    int pop = stack1.pop();
                    stack2.push(pop);
                    map.put(pop, right);
                    cost++;
                } else {
                    int pop = stack2.pop();
                    stack1.push(pop);
                    map.put(pop, left);
                    cost++;
                }
            }
        }

        return arr;
    }
}

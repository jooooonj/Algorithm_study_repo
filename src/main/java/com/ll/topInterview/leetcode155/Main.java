package com.ll.topInterview.leetcode155;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {

    }
}
class MinStack {
    // stack
    private Stack<Integer> stack;

    // 최솟값을 구하기 위해
    // stack에 저장된 값을 중복없이 저장할 arrayList<>를 생성한다.
    ArrayList<Integer>list = new ArrayList<>();

    // stack 초기화
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        // stack에 존재하는 값들과 중복되지 않는 값이면,
        // arrayList에 값을 추가한다.
        if(!stack.contains(val)) list.add(val);

        stack.push(val);
    }

    public void pop() {
        // stack에서 제거할 숫자
        int num = stack.peek();

        stack.pop();

        // stack에서 num을 제거한 이후에 stack 안에 num이 존재하지 않으면,
        // arrayList에도 num을 제거한다.
        if(!stack.contains(num)) list.remove(Integer.valueOf(num));
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        // list내에서 최솟값을 구한다.
        int min = Collections.min(list);
        return min;
    }
}
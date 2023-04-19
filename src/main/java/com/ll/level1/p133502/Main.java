package com.ll.level1.p133502;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        int[] test = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        int[] test2 = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        Solution s = new Solution();
        s.solution(test);
    }
}

class Solution {
    public int solution(int[] ingredient) {
        int result = 0;

        Stack<Integer> stack = new Stack<>();

        for (int num : ingredient) {
            stack.add(num);
        }

        int count = 0;
        int num = -1;
        int num2 = -1;
        while (!stack.isEmpty()) {
            num = stack.pop();
            if(num == num2 + 1)
                count++;
            else
                count = 0;
            num2 = num;
        }

        return result;
    }
}

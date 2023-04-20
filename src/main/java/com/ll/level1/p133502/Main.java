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

            if (stack.size() >= 4) {
                boolean isMake = true;
//                    System.out.println(stack.size() - i);
                if (stack.get(stack.size() - 4) != 1) isMake = false;
                if (stack.get(stack.size() - 3) != 2) isMake = false;
                if (stack.get(stack.size() - 2) != 3) isMake = false;
                if (stack.get(stack.size() - 1) != 1) isMake = false;

                if (isMake) {
                    result++;
                    for (int i = 0; i < 4; i++) {
                        stack.pop();
                    }
                }
            }
        }
        System.out.println(result);
        return result;
    }
}

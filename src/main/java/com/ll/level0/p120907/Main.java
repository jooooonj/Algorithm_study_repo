package com.ll.level0.p120907;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] result = s.solution(new String[]{"-19 + 6 = -13", "5 + 66 = 71", "-5 - 15 = -20", "3 - 1 = 2"});

        for(String str : result)
            System.out.println(str);
    }
}
class Solution {
    public String[] solution(String[] quiz) {
        String[] result = new String[quiz.length];

        for(int i=0; i<quiz.length; i++){
            String str = quiz[i];

            String[] split = str.split(" ");
            int a = Integer.parseInt(split[0]);
            int b = Integer.parseInt(split[2]);
            int c = Integer.parseInt(split[4]);

            if (split[1].equals("+")) {
                if(a + b == c)
                    result[i] = "O";
                else
                    result[i] = "X";
            }

            if (split[1].equals("-")) {
                if (a - b == c)
                    result[i] = "O";
                else
                    result[i] = "X";
            }

        }
        return result;
    }
}
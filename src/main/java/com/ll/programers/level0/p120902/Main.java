package com.ll.programers.level0.p120902;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int solution = s.solution("3 - 1");
        System.out.println(solution);
    }

}
class Solution {
    public int solution(String my_string) {
        String[] s = my_string.split(" ");
        int sum = Integer.parseInt(s[0]);

       for(int i=1; i<s.length-1; i++){
           if (s[i].equals("+")) {
               sum += Integer.parseInt(s[i + 1]);
           } else if (s[i].equals("-")) {
               sum -= Integer.parseInt(s[i + 1]);
           }
       }
       return sum;
    }
}

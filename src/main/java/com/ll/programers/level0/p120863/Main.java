package com.ll.programers.level0.p120863;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String result = s.solution("7 + 2");
        System.out.println(result);
    }
}
class Solution {
    //동류항끼리 더한 결과값 리턴
    // 같은 식이라면 가장 짧은 수식 리턴
    public String solution(String polynomial) {
        String[] strArr = polynomial.split(" \\+ ");

        int plus = 0;
        int num = 0;
        for(int i=0; i<strArr.length; i++){
            if(strArr[i].equals("x"))
                strArr[i] = "1x";

            if (strArr[i].contains("x")) {
                plus += Integer.parseInt(strArr[i].replace("x", ""));
            } else {
                num += Integer.parseInt(strArr[i]);
            }
        }

        String plusResult = "";
        String numResult = "";
        String result = "";
        if(plus == 1)
            plusResult = "x";
        else if(plus > 1)
            plusResult = plus + "x";

        if(num > 0) numResult = String.valueOf(num);

        if(plus > 0 && num > 0){
            result = plusResult + " + " + num;
        } else
            result = plusResult + numResult;



        return result;
    }
}

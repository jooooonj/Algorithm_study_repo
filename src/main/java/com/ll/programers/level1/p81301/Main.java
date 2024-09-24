package com.ll.programers.level1.p81301;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(String s) {
        String[] arr = new String[10];

        arr[0] = "zero";
        arr[1] = "one";
        arr[2] = "two";
        arr[3] = "three";
        arr[4] = "four";
        arr[5] = "five";
        arr[6] = "six";
        arr[7] = "seven";
        arr[8] = "eight";
        arr[9] = "nine";

        String result = "";
        String str = "";
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            //숫자가 아니라면
            if(ch-'0' < 0 || ch-'0' > 9){
                str += ch;
            } else {
                str = "";
                result += ch;
            }

            for(int j=0; j<10; j++){
                if(str.equals(arr[j])){
                    result += j;
                    str = "";
                }
            }
        }

        return Integer.parseInt(result);
    }
}
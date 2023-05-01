package com.ll.programers.level0.p120853;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(String s) {
        String[] strArr = s.split(" ");
        int N = strArr.length;
        int sum = 0;
        for(int i=0; i<N; i++){
            if(!strArr[i].equals("Z"))
                sum += Integer.parseInt(strArr[i]);
            else{
                sum -= Integer.parseInt(strArr[i - 1]);
            }
        }
        return sum;
    }
}
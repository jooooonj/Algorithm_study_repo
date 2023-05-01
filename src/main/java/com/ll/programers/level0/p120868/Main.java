package com.ll.programers.level0.p120868;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public int solution(int[] sides) {
        int a;
        int b;
        if(sides[0] > sides[1]){
            a = sides[0];
            b = sides[1];
        } else{
            a = sides[1];
            b = sides[0];
        }
        int result = 0;
        //1.
        result += a - (a - b + 1) + 1;
        //2.
        result += (a+b) - (a+1);

        return result;

    }
}

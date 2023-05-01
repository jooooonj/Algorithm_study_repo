package com.ll.programers.level0.p120891;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int order) {
        int n = 1;
        int count = 0;
        while(n!=0){
            n = order%10;
            if(n==3 || n==6 || n==9)
                count++;
            order /= 10;
        }
        return count;
    }
}

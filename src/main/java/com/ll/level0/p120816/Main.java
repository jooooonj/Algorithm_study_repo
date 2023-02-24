package com.ll.level0.p120816;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int slice, int n) {
        int result = 0;
        if (n % slice == 0){
            result = n/slice;
        } else{
            result = n/slice +1;
        }
        return result;
    }
}
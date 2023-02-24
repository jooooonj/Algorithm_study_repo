package com.ll.level0.p120837;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int hp) {
        int[] arr = {5, 3, 1};
        int sum =0;
        for(int i=0; i<3; i++){
            sum += hp/arr[i];
            hp = hp%arr[i];
        }
        return sum;
    }
}


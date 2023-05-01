package com.ll.programers.level0.p120819;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(int money) {
        int americano = 5500;
        int[] arr = new int[2];

        arr[0] = money / americano;
        arr[1] = money % americano;

        return arr;
    }
}
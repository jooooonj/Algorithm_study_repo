package com.ll.level0.p120818;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int price) {
        int answer = 0;
        int discountPercent = 100;

        if(price>=500000){
            discountPercent-=20;
        } else if(price>=300000){
            discountPercent-=10;
        } else if(price>=100000){
            discountPercent-=5;
        }

        return price * discountPercent / 100;
    }
}

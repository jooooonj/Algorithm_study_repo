package com.ll.programers.level1.p134240;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        String answer = "";

        for(int i=1; i<food.length; i++){
            int f = food[i];

            for(int j=0; j< f/2; j++){
                sb.append(i);
            }
        }

        sb.append(0);

        for(int i=food.length - 1; i >= 0; i--){
            int f = food[i];

            for(int j=0; j< f/2; j++){
                sb.append(i);
            }
        }

        return sb.toString();
    }
}

package com.ll.level0.p120887;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        while(i<=j){
            String ii = Integer.toString(i);
            char kk = (char)(k+'0');

            for(int q=0; q<ii.length(); q++){
                if(kk==ii.charAt(q)){
                    count++;
                }
            }
            i++;
        }
        return count;
    }
}

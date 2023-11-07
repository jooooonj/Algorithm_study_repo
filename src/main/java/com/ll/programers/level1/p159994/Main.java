package com.ll.programers.level1.p159994;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String yes = "Yes";
        String no = "No";

        int p1 = 0;
        int p2 = 0;

        for(String word : goal){
            if(p1 < cards1.length && cards1[p1].equals(word))
                p1++;
            else if(p2 < cards2.length && cards2[p2].equals(word))
                p2++;

            else
                return no;
        }

        return yes;
    }
}
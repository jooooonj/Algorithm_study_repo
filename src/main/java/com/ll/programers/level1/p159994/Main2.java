package com.ll.programers.level1.p159994;

public class Main2 {
    public static void main(String[] args) {

    }
}

class Solution2 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        for(String g : goal){

            if(index1 < cards1.length && g.equals(cards1[index1])){
                index1++;
                continue;
            }

            if(index2 < cards2.length && g.equals(cards2[index2])){
                index2++;
                continue;
            }

            return "No";
        }

        return "Yes";
    }
}
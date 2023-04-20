package com.ll.level2.p150368;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emoticons = {7000, 9000};

        int[][] users2 = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons2 = {1300, 1500, 1600, 4900};

        int[] result = s.solution(users2, emoticons2);
        System.out.println(Arrays.toString(result));
    }
}

class Solution {
    // 10,20,30,40 (%)
    static double[] discount = {0.1,0.2,0.3,0.4};
    static int[] discountResult;
    static int[] result = new int[2];
    static int emoticonPlus = 0;
    static int sale = 0;
    static int M;
    static int[] emoticons;
    static int[][] users;
    static int[] userValue;

    public int[] solution(int[][] users, int[] emoticons) {
        M = emoticons.length;
        discountResult = new int[M];
        this.emoticons = emoticons;
        this.users = users;
        userValue = new int[users.length];

        select(0,0);

        return result;
    }
    static void select(int count, int index){
        sale = 0;
        emoticonPlus = 0;

        if(count == M){
            for(int[] user : users){
                int value = 0;
                for(int i = 0; i < M; i++){

                    if(user[0] <= discountResult[i]){
                        value += emoticons[i] * (100-discountResult[i]) / 100;
                    }
                }
                if(value >= user[1]){
                    emoticonPlus++;
                } else{
                    sale += value;
                }
            }

            if(result[0] < emoticonPlus){
                result[0] = emoticonPlus;
                result[1] = sale;
            } else if(result[0] == emoticonPlus){
                if(result[1] < sale)
                    result[1] = sale;
            }

            return;
        }

        for(int i=0; i<4; i++){
            discountResult[index] = (int)(discount[i] * 100);
            select(count + 1, index + 1);
        }
    }
}

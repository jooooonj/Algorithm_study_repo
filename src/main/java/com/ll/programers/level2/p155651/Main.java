package com.ll.programers.level2.p155651;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

        String[][] book_time = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
        s.solution(book_time);

    }
}

class Solution {
    public int solution(String[][] book_time) {
        // 빠른 입실 순으로 정렬
        // 입실 시점이 퇴실 + 10분 시점 이하인 방이 있는지 확인
        // 들어갈 방이 없으면 count++

        int[][] bookTime = new int[book_time.length][2];

        for(int i=0; i<book_time.length; i++){
            String startTime = book_time[i][0].replace(":", "");
            String endTime = book_time[i][1].replace(":", "");

            bookTime[i][0] = Integer.parseInt(startTime);
            bookTime[i][1] = Integer.parseInt(endTime);
        }

        Arrays.sort(bookTime, (a1, a2) -> {
            return a1[0] - a2[0];
        });

        int count = 0;
        for(int i=0; i<bookTime.length; i++){
            int startTime = bookTime[i][0];

            boolean needRoom = true;
            for(int j=0; j<i; j++){
                int endTime = bookTime[j][1] + 10;

                if(startTime >= endTime){
                    needRoom =  false;
                    break;
                }
            }

            if(needRoom){
                count++;
            }
        }

        return count;
    }
}
package com.ll.programers.level1.p150370;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String today = "2020.01.01";
        String[] terms = {"Z 3", "D 5"};
        String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

        String today2 = "2022.12.08";
        String[] terms2 = {"A 6"};
        String[] privacies2 = {"2022.06.08 A"};

        String today3 = "2021.12.08";
        String[] terms3 = {"A 18"};
        String[] privacies3 = {"2020.06.08 A"};



        Solution s = new Solution();
        s.solution(today3, terms3, privacies3);
    }
}

class Solution {
    Day toDay;

    class Day {
        int year;
        int month;
        int date;

        Day(String year, String month, String date) {
            this.year = Integer.valueOf(year);
            this.month = Integer.valueOf(month);
            this.date = Integer.valueOf(date);
        }

        public String toString() {
            return year + "." + month + "." + date;
        }
    }

    public int[] solution(String today, String[] terms, String[] privacies) {
        toDay = makeDay(today);

        //각 약관종류가 유효기간이 몇인지 저장
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String[] split = terms[i].split(" ");
            map.put(split[0], Integer.valueOf(split[1]));
        }

        List<Day> dayList = new ArrayList<>();
        for (String str : privacies) {
            String[] split = str.split(" ");

            Day day = makeDay(split[0]);
            int during = map.get(split[1]);
            dayList.add(calc(day, during));
        }

        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < dayList.size(); i++) {
            Day day = dayList.get(i);
            if (shouldDelete(day)){
                answer.add(i + 1);
            }
        }

        int[] arr = new int[answer.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = answer.get(i);
        }

        System.out.println(Arrays.toString(arr));
        return arr;


    }

    Day makeDay(String today) {
        String[] split = today.split("\\.");
        String year = split[0];
        String month = split[1];
        String date = split[2];
        return new Day(year, month, date);
    }

    //계산해주는 애
    Day calc(Day today, int during) {
        today.month += during;
        today.date -= 1;

        if (today.date == 0) {
            today.date = 28;
            today.month -= 1;
        }

        while (today.month > 12) {
            today.year += 1;
            today.month -= 12;
        }



        return today;
    }


    //지워야 되는지
    boolean shouldDelete(Day day) {
        if (toDay.year < day.year)
            return false;

        if (toDay.year > day.year)
            return true;

        if (toDay.month < day.month)
            return false;

        if (toDay.month > day.month)
            return true;

        if (toDay.date > day.date)
            return true;

        return false;
    }

}

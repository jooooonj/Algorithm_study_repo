package com.ll.programers.level2.p72412F;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};
        s.solution(info, query);
    }
}

class Solution {
    class Person{
        String lan;
        String skill;
        String level;
        String cook;
        String score;

        Person(String lan, String skill, String level, String cook, String score){
            this.lan = lan;
            this.skill = skill;
            this.level = level;
            this.cook = cook;
            this.score = score;
        }

        //주어진 조건에 일치하는지 검사하는 함수
        boolean isCorrect(String lan, String skill, String level, String cook){
            if(lan.equals("-")) lan = this.lan;
            if(skill.equals("-")) skill = this.skill;
            if(level.equals("-")) level = this.level;
            if(cook.equals("-")) cook = this.cook;

            if (this.lan.equals(lan) &&
                    this.skill.equals(skill) &&
                    this.level.equals(level) &&
                    this.cook.equals(cook)){
                return true;
            }

            return false;
        }
    }
    public int[] solution(String[] info, String[] query) {
        List<Person> studentList = new ArrayList<>();
        for(String str : info){
            String[] split = str.split(" ");
            String lan = split[0];
            String skill = split[1];
            String level = split[2];
            String cook = split[3];
            String score = split[4];
            studentList.add(new Person(lan,skill,level,cook,score));
        }

        Collections.sort(studentList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return Integer.parseInt(o1.score) - Integer.parseInt(o2.score);
            }
        });

        int[] result = new int[query.length];

        for(int i=0; i<query.length; i++){
            String q = query[i];
            int count = 0; //몇명인지 셀 함수

            String[] split = q.split(" ");
            String lan = split[0];
            String skill = split[2];
            String level = split[4];
            String cook = split[6];
            String score = split[7];
            int index = 0;

            if(!score.equals("-"))
                index = binarySearch(studentList, 0, studentList.size()-1, Integer.parseInt(score));

            for(int j=index; j<studentList.size(); j++){
                Person person = studentList.get(j);
                if(person.isCorrect(lan,skill,level,cook))
                    count++;
            }

            result[i] = count;
        }

        return result;
    }

    int binarySearch(List<Person> studentList, int left, int right, int key){

        int m;
        while(left<=right){
            m = (left + right)/2;

            Person person = studentList.get(m);
            int score = Integer.parseInt(person.score);

            if(key<=score)
                right = m-1;
            else
                left = m+1;
        }

        return left;

    }
}


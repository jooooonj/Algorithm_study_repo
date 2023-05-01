package com.ll.programers.level1.p92334;

import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    class People{
        private List<Person> list = new ArrayList<>();

        People(List<Person> list){
            this.list = list;
        }

        public void addPerson(Person person){
            list.add(person);
        }

    }
    class Person{
        String name;
        Set<String> from; //내가 신고한 사람
        Set<String> to; // 나를 신고한 사람
        int count = 0;
        Person(String name) {
            this.name = name;
            from = new HashSet<>();
            to = new HashSet<>();
        }
        public void iReport(String name){
            from.add(name);
        }
        public void reportMe(String name){
            to.add(name);
        }
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        People people = new People(new ArrayList<>());
        Map<String, Integer> result = new HashMap<>();

        for(String name : id_list){
            people.addPerson(new Person(name));
            result.put(name, 0);
        }

        for(String repo : report){
            String[] split = repo.split(" ");
            String from = split[0];
            String to = split[1];

            for(Person person : people.list){
                if(person.name.equals(from)){
                    person.iReport(to);
                }
                if(person.name.equals(to)){
                    person.reportMe(from);
                }
            }
        }

        for(Person person : people.list){
            if(person.to.size()>=k){
                for(String name : person.to){
                    result.put(name, result.get(name) + 1);
                }
            }
        }
        int[] value = new int[id_list.length];
        int index = 0;
        for(String name : id_list){
            value[index++] = result.get(name);
        }

        return value;
    }
}
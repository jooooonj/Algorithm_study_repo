package com.ll.baekjoon.Baekjoon10814;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    static class Person{
        int age;
        String name;
        int seq;
        Person(int age, String name, int seq){
            this.age =age;
            this.name =name;
            this.seq = seq;
        }

        public String toString(){
            return age+" "+name;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Person[] people = new Person[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();

            people[i] = new Person(age, name, i);
        }

        Arrays.sort(people, new Comparator<Person>(){
            public int compare(Person p1, Person p2){
                if(p1.age > p2.age)
                    return 1;
                else if(p1.age == p2.age){
                    return p1.seq - p2.seq;
                } else
                    return -1;
            }
        });

        for(Person p : people){
            System.out.println(p.toString());
        }
    }
}

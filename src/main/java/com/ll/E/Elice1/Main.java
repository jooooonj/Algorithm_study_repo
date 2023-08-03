package com.ll.E.Elice1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
public class Main {
    static int N;
    static int M;
    static Person[] people;
    static class Person{
        int s;
        int e;
        Person(int s, int e){
            this.s = s;
            this.e = e;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        people = new Person[N];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            min = Math.min(s, min);
            int e = Integer.parseInt(st.nextToken());
            max = Math.max(e, max);
            people[i] = new Person(s,e);
        }
        int[] time = new int[max+1];

        Arrays.sort(people, new Comparator<Person>(){

            @Override
            public int compare(Person p1, Person p2) {
                return p1.s - p2.s;
            }
        });

        int count = 0;

        for(int i=0; i<N; i++){
            Person curr = people[i];

            for(int j=curr.s; j<=curr.e; j++){
                time[j]++;
            }
        }

        int result = -1;
        for(int i=min; i<=max; i++){
            if(time[i] >= M){
                result = i;
                break;
            }
        }

        System.out.print(result);
    }
}
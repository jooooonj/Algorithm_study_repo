package com.ll.baekjoon.Baekjoon20920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>(); //중복 제거한 단어 기록용
        for(int i=0; i<N; i++){
            String word = br.readLine();
            if(word.length() >= M){ // M이상인 경우에만 단어장에 !
                if(!map.containsKey(word)){ //처음 나오는 단어면
                    map.put(word, 1); //map에 저장
                    list.add(word); //lsit에 저장
                }
                else {
                    map.put(word, map.get(word) + 1); //개수 누적
                }
            }
        }

        Collections.sort(list, new Comparator<String>(){
            public int compare(String s1, String s2){
                if(map.get(s1) < map.get(s2))
                    return 1;
                else if(map.get(s1) > map.get(s2))
                    return -1;
                else{ //같으면
                    if(s1.length() < s2.length())
                        return 1;
                    else if(s1.length() > s2.length())
                        return -1;
                    else{
                        return s1.compareTo(s2);
                    }
                }
            }
        });

        for (String s : list) {
            sb.append(s+"\n");
        }
        System.out.println(sb);


    }
}

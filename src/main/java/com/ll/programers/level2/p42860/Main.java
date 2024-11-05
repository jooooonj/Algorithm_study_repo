package com.ll.programers.level2.p42860;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

//        s.solution("LABLPAJM");
        int value = s.solution("BABAAA");
        System.out.println(value);
//        s.solution("BMOABA");
//        s.solution("LAABAA");
//        s.solution("SAAAAAARRM");
//        s.solution("RABAMATAWADLAFAVAAE");
//        s.solution("XAAAAAABA");
//        s.solution("AYOZAAVADAY");
//        s.solution("AAFEASAAVA");
//        s.solution("UAGAAASAAFAFXZA");
//        s.solution("AAAAZAATAEA");
//        s.solution("AACALATLAHABAA");
//        s.solution("FAWJAAAFV");
//        s.solution("AACAVAAPSAAOAA");
//        s.solution("AKAAWAKX");
//        s.solution("K");
//        s.solution("W");
//        s.solution("K");
//        s.solution("X");
//        s.solution("LOAAAHAJAAFAEBAWO");
//        s.solution("BABAAAAAAB");
//        s.solution("BBBAAAAAB");
    }
}

class Solution {
    static int alphabetCount = 26;
    public int solution(String name) {

        int count = 0;
        int index = 0;
        for(int i=0; i<name.length(); i++){
            char ch = name.charAt(i);

            int seq = (int) ch-'A';
            if(seq != 0){
                //위와 아래 어떤 경로가 최소인지
                count+= Math.min(seq, alphabetCount - seq);
            }
        }

        int min = name.length()-1; //그냥 직진했을 경우 최소 횟수

        for(int i=0; i<name.length(); i++){
            //다음 타겟 잡아서 뒤로 돌아가는 것과 앞으로 가는 것 비교

            int next = i+1;
            while(next < name.length() && name.charAt(next) == 'A'){
                next++;
            }

            min = Math.min(min, i*2 + name.length() - next);
            min = Math.min(min, (name.length() - next) * 2 + i);
        }


        return count + min;
    }
}
package com.ll.programers.level1.p160586;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] alpha = new int[26];
        Arrays.fill(alpha, Integer.MAX_VALUE); //전체 다 최대수로 바꾸고

        for(String s : keymap){
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i); //문자열을 몇번만에 가능하지 미리 저장

                int index = ch - 'A';
                if(alpha[index] > i + 1)
                    alpha[index] = i+1;
            }
        }

        int[] result = new int[targets.length];

        for(int j=0; j< targets.length; j++){
            String s = targets[j];
            int count = 0;
            for(int i=0; i<s.length(); i++){
                char ch = s.charAt(i);

                int num = alpha[ch-'A'];
                if(num == Integer.MAX_VALUE){
                    count = -1;
                    break;
                }

                count += num;
            }

            result[j] = count;
        }

        return result;
    }
}
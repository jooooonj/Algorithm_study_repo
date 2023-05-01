package com.ll.programers.level0.p120838;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(".... . .-.. .-.. ---");
    }
}

class Solution {
    public String solution(String letter) {
        String[] mos = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String result = "";
        StringTokenizer st = new StringTokenizer(letter);

        List<String> list = new ArrayList<>(Arrays.asList(mos));

        while(st.hasMoreTokens()){
            int index = list.indexOf(st.nextToken());
            char ch = (char) (index + 97);
            result += ch;
        }
        return result;
    }
}

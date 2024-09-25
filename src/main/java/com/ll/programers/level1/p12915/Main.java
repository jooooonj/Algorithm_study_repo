package com.ll.programers.level1.p12915;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String[] strArr = {"sun", "bed", "car"};

        s.solution(strArr, 1);
    }
}

class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];

        List<String> stringList = new ArrayList<>();
        for(int i=0; i<strings.length; i++){
            char ch = strings[i].charAt(n);

            stringList.add(ch + strings[i]);
        }

        Collections.sort(stringList);

        for(int i=0; i<strings.length; i++){
            answer[i] = stringList.get(i).substring(1, stringList.get(i).length());
        }

        return answer;
    }
}

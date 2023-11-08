package com.ll.programers.level1.p42576;

import java.util.Arrays;

public class Main {

}

class Solution {
    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0; i<participant.length; i++){
            if(i==participant.length-1)
                return participant[i];

            if(!participant[i].equals(completion[i]))
                return participant[i];
        }

        return "";
    }
}

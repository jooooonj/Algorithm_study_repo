package com.ll.programers.level2.p42885;

import java.util.Arrays;

public class Main {
}

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int s = 0;
        int count = 0;
        for(int i=people.length -1; i>=s; i--){
            int heavyWeight = people[i];

            if(limit >= people[s] + heavyWeight){
                count++;
                s++;
            } else {
                count++;
            }
        }

        return count;
    }
}

package com.ll.programers.level1.p12982;

import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);


        int count = 0;
        int sum = 0;
        for(int i=0; i<d.length; i++){
            if(sum+d[i] > budget) {
                break;
            }

            count++;
            sum += d[i];
        }

        return count;
    }
}

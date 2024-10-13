package com.ll.programers.level2.p12936;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();

        k--;

        int[] answer = new int[n];

        long factorial = 1;
        for(int i=0; i<n; i++){
            factorial *= (i+1);
            list.add(i+1);
        }

        int index = 0;
        while(n > 0){
            factorial /= n;

            int value = (int) (k / factorial);

            answer[index++] = list.get(value);

            list.remove(value);
            k %= factorial;
            n--;
        }

        return answer;
    }
}

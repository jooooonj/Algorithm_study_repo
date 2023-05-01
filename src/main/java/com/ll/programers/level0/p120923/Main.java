package com.ll.programers.level0.p120923;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(5, 5);
        System.out.println(Arrays.toString(result));
    }
}
class Solution {
    public int[] solution(int num, int total) {
        int[] arr = new int[num];
        int m1 = -1;
        int m2 = -1;
        if (total % num == 0) {
            m1 = num / 2;
            m2 = num / 2;
        } else{
            m1 = num / 2 - 1;
            m2 = num / 2 - 1;
        }

        arr[m1] = total/num;

        while (m1 > 0) {
            --m1;
            arr[m1] = arr[m1+1] - 1;
        }
        while(m2 < arr.length -1){
            ++m2;
            arr[m2] = arr[m2 -1] + 1;
        }

      return arr;
    }
}


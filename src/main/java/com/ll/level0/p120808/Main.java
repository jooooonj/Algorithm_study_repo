package com.ll.level0.p120808;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(9,2,1,3);

        System.out.println(Arrays.toString(solution));

    }
}

class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int[] arr = new int[2];
        int denom = (denom1 * denom2) / gdc(denom1, denom2);

        int numer = (denom / denom1) * numer1 + (denom / denom2) * numer2;

        int gdc = gdc(denom, numer);

        numer /= gdc;
        denom /= gdc;
        arr[0] = numer;
        arr[1] = denom;
        return arr;



    }



    public int gdc(int a, int b){

        if(b == 0)
            return a;

        return gdc(b, a%b);
    }
}

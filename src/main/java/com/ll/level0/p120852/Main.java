package com.ll.level0.p120852;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution(360);
    }
}

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        int p = 2;
        while(p<=n){
            if(n%p==0) {
                n /= p;
                if (!list.contains(p))
                    list.add(p);
            } else
                p++;
        }
        int[] arr = new int[list.size()];
        int index = 0;
        for(int a : list){
            arr[index++] = a;
        }
        return arr;
    }
}

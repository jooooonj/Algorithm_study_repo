package com.ll.level0.p120897;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] solution = s.solution(24);
        System.out.print(Arrays.toString(solution));
    }
}

class Solution {
    public int[] solution(int n) {
        List<Integer> list = new ArrayList<>();

        for(int i=1; i<=n; i++){
            if(n%i==0)
                list.add(i);
        }
        Collections.sort(list);
        int[] arr = new int[list.size()];
        int index =0;
        for(int num : list){
            arr[index++] = num;
        }
        return arr;
    }
}
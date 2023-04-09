package com.ll.level0.p120880;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] result = s.solution(new int[]{1, 2, 3, 4, 5, 6}, 4);

        System.out.println(Arrays.toString(result));

    }
}
class Solution {
    public int[] solution(int[] numlist, int n) {
        //n과 가까운 수부터 정렬
        //거리가 같다면 더 큰수를 앞에 오도록 배치

        int[][] arr = new int[numlist.length][2];
        int[] result = new int[numlist.length];
        for(int i=0; i<arr.length; i++){
            arr[i][0] = Math.abs(n - numlist[i]);
            arr[i][1] = numlist[i];
        }

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i][0]+", "+arr[i][1]);
        }

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });

        for(int i = 0; i< result.length; i++){
            result[i] = arr[i][1];
        }

        return result;
    }
}

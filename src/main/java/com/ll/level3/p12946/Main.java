package com.ll.level3.p12946;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] solution = s.solution(3);

        for(int i=0; i<solution.length; i++){
            for(int j=0; j<2; j++){
                System.out.print(solution[i][j]+" ");
            }
            System.out.println();
        }
    }
}

class Solution {
    public int[][] solution(int n) {
        List<int[]> list = new ArrayList<>();
        hanoi(n,1,2,3, list);
        int[][] result = list.toArray(new int[list.size()][list.get(0).length]);

        return result;
    }

    //n번 원판이 a에서 b로 이동해라
    public void hanoi(int n, int a, int b, int c, List<int[]> list){
        if(n==1){
            list.add(new int[]{a,c});
            return;
        }

        hanoi(n-1, a,c,b, list);
        list.add(new int[]{a,c});
        hanoi(n-1, b,a,c, list);
    }

}
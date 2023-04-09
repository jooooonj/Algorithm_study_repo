package com.ll.level0.p120871;
/////////////////////마저 풀어야함 저주의 숫자 3
public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int solution = s.solution(15);
        System.out.println(solution);
    }
}

class Solution {
    public int solution(int n) {
        int num = 1;
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
//            System.out.println("i = " + i);
            String str = Integer.toString(num);
            char ch = str.charAt(str.length() - 1);

            while(num%3==0 || ch-'0' == 3 || (num-30 >=0 && num-30 <= 9)){
                num ++;
                str = Integer.toString(num);
                ch = str.charAt(str.length() - 1);
            }

            arr[i] = num;
//            System.out.println(num);
            num ++;
//            System.out.println(Arrays.toString(arr));
        }

        return arr[arr.length - 1];
    }
}

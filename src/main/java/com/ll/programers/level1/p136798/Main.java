package com.ll.programers.level1.p136798;

public class Main {
}

class Solution {
    public int solution(int number, int limit, int power) {
        int[] numArr = new int[number+1];

        for(int i=1; i<=number; i++){
            int num = i;
            int count = 0;
            for(int j=1; j*j<=num; j++){
                if(j*j == num) count++;
                else if(num % j == 0) count+=2;
            }

            numArr[i] = count;
        }
        
        int sum = 0;
        for(int n : numArr){
            if(n > limit) sum += power;
            else
                sum += n;
        }

        return sum;
    }
}
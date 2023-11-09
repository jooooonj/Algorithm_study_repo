package com.ll.programers.level1.p12977;

import java.util.Arrays;

public class Main {

}

class Solution {
    public boolean[] isPrime;
    public int count = 0;
    public int length;
    public int[] numbers;

    public int solution(int[] nums) {
        Arrays.sort(nums);
        length = nums.length;

        int num = nums[nums.length-1] + nums[nums.length-2] + nums[nums.length-3]; //최대 큰 수
        numbers = nums;
        //1~num 까지의 소수 먼저 구해보자.

        isPrime = new boolean[num+1];
        isPrime[0] = true;
        isPrime[1] = true;

        makePrime(num+1);

        //경우의 수 탐색
        for(int i=0; i<length; i++){
            for(int j=i+1; j<length; j++){
                for(int k=j+1; k<length; k++){
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrime[sum] == false) count++;
                }
            }
        }


        return count;
    }

    public void makePrime(int num){
        if(num < 2) return;

        for(int i=2; i*i<=num; i++){
            if(isPrime[i]) continue;

            for(int j=i*i; j<num; j+=i){
                isPrime[j] = true;
            }
        }
    }
}

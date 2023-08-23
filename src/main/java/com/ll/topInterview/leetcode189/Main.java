package com.ll.topInterview.leetcode189;

public class Main {

}

class Solution {
    public void rotate(int[] nums, int k) {
        int index = 0;
        int[] tmp = new int[nums.length];
        k = k%nums.length;
        for(int i=nums.length-k; i<nums.length; i++){
            tmp[index++] = nums[i];
        }

        for(int i=nums.length-k-1; i>=0; i--){
            nums[i+k] = nums[i];
        }

        for(int i=0; i<k; i++){
            nums[i] = tmp[i];
        }
    }
}

package com.ll.topInterview.leetcode55;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        boolean isSuccess = false;

        for(int i=nums.length-2; i>=0; i--){
            if(i + nums[i] >= target)
                target = i;
        }

        if(target != 0)
            return false;
        return true;
    }
}
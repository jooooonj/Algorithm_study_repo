package com.ll.topInterview.leetcode169;

import java.util.Arrays;

public class Main {

}

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
package com.ll.topInterview.leetcode80;

public class Main {

}

class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if(index < 2 || num != nums[index-2])
                nums[index++] = num;
        }
        return index;
    }
}

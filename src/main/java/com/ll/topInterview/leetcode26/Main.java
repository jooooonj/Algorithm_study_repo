package com.ll.topInterview.leetcode26;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

}
class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new LinkedHashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int index = 0;
        for (Integer num : set) {
            nums[index++] = num;
        }

        return set.size();
    }
}
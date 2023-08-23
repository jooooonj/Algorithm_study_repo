package com.ll.topInterview.leetcode27;

import java.util.ArrayList;
import java.util.List;

public class Main {

}

//정수 배열 nums와 정수 val이 주어지면 nums에서 발생하는 모든 val을 제자리에서 제거합니다.
// 요소의 순서는 변경될 수 있습니다. 그런 다음 val과 같지 않은 요소 수를 nums로 반환합니다.
//val be k와 같지 않은 nums의 요소 수를 고려하여 승인을 받으려면 다음 작업을 수행해야 합니다.
//nums의 처음 k개 요소에 val과 같지 않은 요소가 포함되도록 배열 nums를 변경합니다.
// nums의 나머지 요소는 nums의 크기만큼 중요하지 않습니다.
//k를 반환합니다.
class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            if(nums[i] != val)
                list.add(nums[i]);
        }

        for(int i=0; i<list.size(); i++){
            nums[i] = list.get(i);
        }
        return list.size();
    }
}

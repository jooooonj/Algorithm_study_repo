package com.ll.topInterview.leetcode141;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public boolean hasCycle(ListNode head) {

        ArrayList<ListNode> arraylist = new ArrayList();

        if (head == null || head.next == null){
            return false;
        }

        while(true){

            // ListNode를 while문으로 -> ArrayList에 저장
            arraylist.add(head);
            head = head.next;

            // arraylist를 for문을 이용해 ListNode의 val 이 ArrayList에 있는지를 판단
            for(int i = 0 ; i < arraylist.size(); i++){
                if (arraylist.get(i) == head){
                    return true;
                }
            }
            if (head.next == null){
                break;
            }
        }
        return false;
    }
}

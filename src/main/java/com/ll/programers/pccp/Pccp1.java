package com.ll.programers.pccp;
import java.util.*;

import java.util.ArrayList;
import java.util.HashSet;

public class Pccp1 {
    public static void main(String[] args) {

    }
}

//바로 옆이 같은거면 continue;
//아니고 같은게 나오면 list에 등록
class Solution {
    public String solution(String input_string) {
        Set<Character> set = new HashSet<>();
        int length = input_string.length();
        for(int i=0; i<length - 1; i++){
            char ch = input_string.charAt(i);
            //만약 바로 옆이 같은 문자면 건너뛰기
            if(ch == input_string.charAt(i+1))
                continue;

            for(int j=i+1; j<length; j++){
                if(ch == input_string.charAt(j)){
                    set.add(ch);
                    break;
                }
            }
        }
        List<Character> list = new ArrayList<>(set);
        String result = "";
        for(int i=0; i<list.size(); i++){
            result += list.get(i);
        }
        if(result.length() == 0)
            return "N";
        return result;
    }
}

package com.ll.programers.level0.p120864;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int result = s.solution("12345a6");
        System.out.println(result);
    }
}

class Solution {
    public int solution(String my_string) {
        List<String> list = new ArrayList<>();
        int p = 0;
        for(int i=0; i<my_string.length(); i++){
            String str = "";
            char ch = my_string.charAt(i);
            if (ch >= '1' && ch <= '9') {
                str+=ch;
//                System.out.println(str);

                for(int j=i+1; j<my_string.length(); j++){
                    char c = my_string.charAt(j);
//                    System.out.println(c);
                    if(c>='0' && c<='9'){
                        str += c;
                        i++;

                    } else{
                        list.add(str);
                        break;
                    }

                }
                if (i == my_string.length() - 1) {
                    list.add(str);
                }
            }
        }
        int sum = 0;
        for (String s : list) {
            sum += Integer.parseInt(s);
        }
        return sum;
    }
}
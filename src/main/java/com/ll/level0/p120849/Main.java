package com.ll.level0.p120849;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String my_string) {
        String[] strArr = {"a", "e", "i", "o", "u"};

        for(int i=0; i<5; i++){
            my_string = my_string.replace(strArr[i], "");
        }

        return my_string;
    }
}

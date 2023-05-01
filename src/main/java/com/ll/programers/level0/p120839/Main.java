package com.ll.programers.level0.p120839;

public class Main {
    public static void main(String[] args) {

    }
}

class Solution {
    public String solution(String rsp) {
        int len = rsp.length();
        String str = "";
        for(int i=0; i<len; i++){
            char ch = rsp.charAt(i);
            if(ch=='2')
                ch = '0';
            else if (ch == '0') {
                ch = '5';
            } else
                ch = '2';
            str += ch;
        }
        return str;
    }
}
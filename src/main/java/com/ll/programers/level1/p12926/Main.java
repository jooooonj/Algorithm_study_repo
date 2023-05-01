package com.ll.programers.level1.p12926;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("a B z", 4);
    }
}
class Solution {
    public String solution(String s, int n) {
        String tmp = "";

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(ch==' ')
                tmp += " ";
            else if(ch >= 'a' && ch <= 'z'){
                tmp += change(ch - 'a' + n, 'a');
            } else if(ch >= 'A' && ch <= 'Z'){
                tmp += change(ch - 'A' + n, 'A');
            }
        }
        System.out.println(tmp);
        return tmp;
    }

    static char change(int num, char c){
        num = num % 26;
        return (char)(num + c);
    }
}


package com.ll.level0.p120869;

public class Main {
    public static void main(String[] args) {
        String[] s1 = {"s", "o", "m", "d"};
        String[] s2 = {"moos", "dzx", "smm", "sunmmo", "som"};

        Solution s = new Solution();
        System.out.println(s.solution(s1, s2));
    }
}
class Solution {
    public int solution(String[] spell, String[] dic) {
        int result = 2;
        for(int i=0; i<dic.length; i++){
            for(int j=0;  j<spell.length; j++){
                if(!dic[i].contains(spell[j]))
                    dic[i] = "zzz";
                dic[i] = dic[i].replaceFirst(spell[j], "");
            }
        }

        for(int i=0; i<dic.length; i++){
            if(dic[i].equals(""))
                result = 1;
        }
        return result;
    }
}

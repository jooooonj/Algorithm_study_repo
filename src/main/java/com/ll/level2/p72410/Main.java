package com.ll.level2.p72410;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("...!@BaT#*..y.abcdefghijklm");
        s.solution("z-+.^.");
        s.solution("=.=");
        s.solution("123_.def");
        s.solution("abcdefghijklmn.p");
    }
}

class Solution {
    public String solution(String new_id) {

        //1단계
        new_id = new_id.toLowerCase();


        //2단계
        if(new_id.length()>0){
            new_id = twoStep(new_id);
        }

        //3단계
        if(new_id.length()>0){
            new_id = threeStep(new_id);
        }

        //4단계
        if(new_id.length()>0){
            new_id = fourStep(new_id);
        }

        //5단계
        new_id = fiveStep(new_id);

        //6단계
        if(new_id.length()>0){
            new_id = sixStep(new_id);
        }

        //7단계
        if(new_id.length()>0){
            new_id = sevenStep(new_id);
        }

        System.out.println(new_id);

        return new_id;
    }

    private String sevenStep(String str) {
        if(str.length()<=2){
            while(str.length()<3)
                str+=str.charAt(str.length() - 1);
        }
        return str;
    }

    private String sixStep(String str) {
        if(str.length() >= 16){
           str = str.substring(0,15);
        }

        if(str.charAt(str.length() - 1)=='.')
            str = str.substring(0,str.length() - 1);
        return str;
    }

    private String fiveStep(String str) {
        if(str.equals(""))
            str += "a";
        return str;
    }

    private String fourStep(String str) {
        String tmp = "";
        if (str.charAt(0) == '.') {
            if(str.length() == 1)
                return tmp;

            for(int i=1; i<str.length() ; i++){
                tmp += str.charAt(i);
            }

            str = tmp;
        }

        tmp = "";

        if (str.charAt(str.length() - 1) == '.') {
            if(str.length() == 1)
                return tmp;

            for(int i=0; i<str.length() -1 ; i++){
                tmp += str.charAt(i);
            }
            str = tmp;
        }

        return str;
    }

    private String twoStep(String str) {
        String tmp = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') ||
                    ch == '-' || ch == '_' || ch == '.') {
                tmp += ch;
            }
        }
        return tmp;
    }

    private String threeStep(String str) {
        String tmp = "";

        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            tmp += ch;

            if(ch=='.'){
                while(i+1 < str.length() && str.charAt(i+1)=='.'){
                    i++;
                }
            }
        }

        return tmp;
    }


}

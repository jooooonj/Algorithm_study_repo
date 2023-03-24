package com.ll.level0.p120883;

public class Main {
    public static void main(String[] args) {

    }
}
class Solution {
    public String solution(String[] id_pw, String[][] db) {
        String id = id_pw[0];
        String pass = id_pw[1];

        String result = "fail";

        for(int i=0; i<db.length; i++){
            if(db[i][0].equals(id)){
                result = "wrong pw";
                if (db[i][1].equals(pass)) {
                    result="login";
                    break;
                }
            }
        }

        return result;
    }
}

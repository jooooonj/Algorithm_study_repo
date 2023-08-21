package com.ll.baekjoon.Baekjoon1515;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int index = 0;
        int num = 1;
        while(true){
            if(num > Integer.MAX_VALUE)
                break;
            String strNum = String.valueOf(num);

            for(int i=0; i<strNum.length(); i++){
                if(strNum.charAt(i) == str.charAt(index)){
                    index++;
                }

                if(index == str.length()){
                    System.out.println(strNum);
                    return;
                }
            }
            num++;
        }
    }
}

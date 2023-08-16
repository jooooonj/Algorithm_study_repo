package com.ll.baekjoon.Baekjoon4659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Character> list = List.of('a', 'e', 'i', 'o', 'u');
        while (true) {
            String str = br.readLine();
            if (str.equals("end"))
                break;

            boolean isSuccess = true;
            boolean isAeiou = false;
            int aeiou = 0; //모음
            int zzzzz = 0; //자음
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);

                if (list.contains(ch)){
                    aeiou++; //모음
                    zzzzz = 0;
                    isAeiou = true; //모음 하나 반드시 포함
                }
                else{
                    zzzzz++;
                    aeiou = 0;
                }

                if (aeiou == 3 || zzzzz == 3) { //모음이나 자음 3개 연속이면 안됨
                    isSuccess = false;
                    break;
                }

                if(i != 0){ //첫번째가 아니고
                    if(ch!='e'&& ch!='o'){ //e나 o 둘다 아니면
                        if(ch == str.charAt(i-1)){ //연속으로 나온거면
                            isSuccess = false; //실패
                            break;
                        }
                    }
                }
            }

            if (isSuccess && isAeiou) //성공인데 모음은 또 나왔어야해
                sb.append("<" + str + ">" + " is acceptable.\n");
            else
                sb.append("<" + str + ">" + " is not acceptable.\n");
        }
        System.out.println(sb);
    }
}

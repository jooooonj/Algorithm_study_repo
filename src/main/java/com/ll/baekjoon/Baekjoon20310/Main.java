package com.ll.baekjoon.Baekjoon20310;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int zero = 0;
        int one = 0;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '0') zero++;
            else one++;
        }

        zero /= 2 ;
        one /= 2;
        int[] except = new int[str.length()];

        // 1개수만큼 앞에서 지우기
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i) == '1'){
                one--;
                except[i] = -1;
            }

            if(one == 0) break;
        }

        // 0개수만큼 뒤에서 지우기
        for(int i=str.length() -1; i>=0; i--){
            if(str.charAt(i) == '0'){
                zero--;
                except[i] = -1;
            }

            if(zero == 0) break;
        }

        for(int i=0; i<str.length(); i++){
            if(except[i] != -1)
                System.out.print(str.charAt(i));
        }
    }
}

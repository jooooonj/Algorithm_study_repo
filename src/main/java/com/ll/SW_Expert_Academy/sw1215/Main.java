package com.ll.SW_Expert_Academy.sw1215;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean check(String str){
        for(int i=0; i<str.length()/2; i++){
            if(str.charAt(i) != str.charAt(str.length()-1-i))
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(br.readLine());

            map = new char[8][8];
            for (int i = 0; i < 8; i++) {
                String str = br.readLine();
                for (int j = 0; j < 8; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            int count = 0;
            for(int i=0; i<8; i++){
                for(int j=0; j<8; j++){
                    String tmp1 = "";
                    String tmp2 = "";

                    if(i+n<=8){
                        for(int r=i; r<i+n; r++){
                            tmp1 += map[r][j];
                        }
                    }

                    if(j+n<=8){
                        for (int c = j; c < j + n; c++) {
                            tmp2 += map[i][c];
                        }
                    }

                    if(tmp1.length()!=0 && check(tmp1))count++;
                    if(tmp2.length()!=0 && check(tmp2))count++;
                }
            }

            sb.append("#" + t + " " + count + "\n");
        }
        System.out.println(sb);
    }
}

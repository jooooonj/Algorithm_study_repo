package com.ll.SW_Expert_Academy.sw1974;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int sum;
    static int[][] map;
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            result = 1;

            sum = 0;
            for(int i=1; i<=9; i++){
                sum += i;
            }

            //9x9
            map = new int[9][9];

            for(int i=0; i<9; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<9; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i=0; i<9; i++){
                int hab = 0;
                for(int j=0; j<9; j++){
                    hab += map[i][j];
                }

                if(hab!=sum){
                    result = 0;
                    break;
                }
            }

            for(int i=0; i<9; i++){
                int hab = 0;
                for(int j=0; j<9; j++){
                    hab += map[j][i];
                }

                if(hab!=sum){
                    result = 0;
                    break;
                }
            }

            for(int i=0; i<9; i+=3){
                for(int j=0; j<9; j+=3){
                    if(!check(i,j)){
                        result = 0;
                        break;
                    }
                }
            }

            sb.append("#"+t+" "+result+"\n");
        }
        System.out.println(sb);
    }

    static boolean check(int r, int c){

        int hab = 0;
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                hab += map[i][j];
            }
        }
        if(hab!=sum) return false;
        return true;
    }
}



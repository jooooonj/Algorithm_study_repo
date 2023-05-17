package com.ll.SW_Expert_Academy.sw1954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int t=1; t<=T; t++){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            int cr = 0;
            int cc = 0;
            // 0 : 오, 1 : 아래, 2 : 왼, 3 : 위
            int direction = 0;
            for(int i=1; i<=n*n; i++){
                arr[cr][cc] = i;

                int count = 4;
                while(true){
                    int nr = cr + dr[direction];
                    int nc = cc + dc[direction];

                    if((nr<0||nc<0||nr>=n||nc>=n) ||
                            arr[nr][nc]>0){
                        direction = (direction + 1) % 4;
                        count --;
                    }
                    else{
                        cr = nr;
                        cc = nc;
                        break;
                    }

                    if(count==0)
                        break;
                }
            }

            sb.append(print(arr, n, t));
        }
        System.out.println(sb);
    }

    static String print(int[][] arr, int n, int t){
        String str = "#"+t+"\n";
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                str += (arr[i][j]+" ");
            }
            str += "\n";
        }

        return str;
    }
}


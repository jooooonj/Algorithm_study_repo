package com.ll.SW_Expert_Academy.sw1926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i<=n; i++){
            int count = 0;
            int num = i;
            while(num!=0){
                if((num%10!=0)&& (num%10) % 3 == 0) count++;
                num /= 10;
            }

            if(count==0)
                sb.append(i+" ");
            if(count==1)
                sb.append("- ");
            if(count==2)
                sb.append("-- ");
        }
        System.out.println(sb);
    }
}

package com.ll.삼성SW역량테스트기출.sw1952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int MIN = Integer.MAX_VALUE;
    static void find(int[] plan, int[] prices, int month, int price){
        if(month>12){
            MIN = Math.min(price, MIN);
            return;
        }

        if(MIN <= price){
            return;
        }

        if(plan[month] == 0)
            find(plan, prices, month + 1, price);

        //0~3
        for(int i=0; i<prices.length; i++){
            if(i==0) //1일권
                find(plan,prices,month+1, price + (plan[month] * prices[i]));
            else if(i==1)//1달권
                find(plan, prices, month + 1, price + prices[i]);
            else if(i==2){//3달권
                if(month > 10) continue;
                find(plan, prices, month + 3, price + prices[i]);
            } else{
                if(month>1)continue;
                find(plan, prices, month + 12, price + prices[i]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){

            //1일, 1달, 3달, 1년 이용권 가격
            int[] prices = new int[4];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                prices[i] = Integer.parseInt(st.nextToken());
            }

            //1~12월 이용계획
            int[] plan = new int[13];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<13; i++){
                plan[i] = Integer.parseInt(st.nextToken());
            }

            find(plan, prices, 1, 0);
            sb.append("#"+(t+1)+" "+MIN+"\n");
            MIN = Integer.MAX_VALUE;
        }
        System.out.println(sb);
    }
}


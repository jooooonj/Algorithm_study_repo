package com.ll.SW_Expert_Academy.sw1859F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] tmp = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i] = num;
                tmp[i] = num;
            }

            Arrays.sort(tmp);
            int sum = 0;
            int count = 0;
            int loss = 0;
            int index = tmp.length - 1;
            int goal = tmp[index--];
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == goal) {
                    sum += (count * arr[j]) - loss;
                    goal = tmp[index--];
                    count = 0;
                    loss = 0;
                    if(index== -1)
                        break;
                } else{
                    count++;
                    loss += arr[j];
                }
            }


            sb.append("#" + t + " " + sum + "\n");
        }
        System.out.println(sb);
    }
}



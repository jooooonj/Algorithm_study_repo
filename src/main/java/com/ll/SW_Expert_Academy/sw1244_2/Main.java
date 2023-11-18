package com.ll.SW_Expert_Academy.sw1244_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int result = 0;
            String numStr = st.nextToken();
            int changeCount = Integer.parseInt(st.nextToken());

            int[] numArr = new int[numStr.length()];

            for (int i = 0; i < numArr.length; i++) {
                numArr[i] = numStr.charAt(i) - '0';
            }

            if(changeCount > numArr.length)
                changeCount = numArr.length;

            max = Integer.MIN_VALUE;

            dfs(numArr, 0, changeCount);

            result = max;

            sb.append("#" + t + " " + result + "\n");
        }

        System.out.println(sb.toString());
    }

    static public void dfs(int[] arr, int depth, int limit) {
        if (depth == limit) {
            int n = 1;
            int num = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                num += arr[i] * n;
                n *= 10;
            }

            max = Math.max(max, num);
            return;
        }

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i; j < arr.length; j++) {
                if (i == j) continue;
                swap(arr, i, j);
                dfs(arr, depth + 1, limit);
                swap(arr, j, i);
            }
        }
    }

    static public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}

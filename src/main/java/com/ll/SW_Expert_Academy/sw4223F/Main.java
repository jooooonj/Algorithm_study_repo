package com.ll.SW_Expert_Academy.sw4223F;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] alpha;
    static String samsung;
    static int MIN;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            alpha = new int[26];
            samsung = "SAMSUNG";
            for (int i = 0; i < samsung.length(); i++) {
                alpha[samsung.charAt(i) - 'A']++;
            }

//            System.out.println(Arrays.toString(alpha));
            MIN = Integer.MAX_VALUE;

            int N = Integer.parseInt(br.readLine());

            String[][] people = new String[N][2];
            visited = new boolean[N];

            for (int i = 0; i < N; i++) {
                int L = Integer.parseInt(br.readLine());
                st = new StringTokenizer(br.readLine());
                String name = "";
                for (int l = 0; l < L; l++) {
                    name += st.nextToken();
                }
                String point = br.readLine();

                people[i][0] = name;
                people[i][1] = point;
            }


            dfs(people, 0, 0);


            sb.append("#" + t + " " + MIN + "\n");
        }

        System.out.println(sb);
    }

    static void dfs(String[][] people, int index, int sum) {

        if (MIN <= sum)
            return;

        if (isSamsung()) {
            MIN = Math.min(MIN, sum);
            return;

        } else {

            for (int n = index; n < people.length; n++) {
                if (visited[n]) continue;

                for (int i = 0; i < people[n][0].length(); i++) {
                    alpha[people[n][0].charAt(i) - 'A']--;
                }
                visited[n] = true;

                dfs(people, n, sum + Integer.parseInt(people[n][1]));

                visited[n] = false;
                for (int i = 0; i < people[n][0].length(); i++) {
                    alpha[people[n][0].charAt(i) - 'A']++;
                }
            }
        }
    }

    static boolean isSamsung() {
        if(alpha['S'-'A'] > 0 || alpha['U'-'A'] > 0
        || alpha['M'-'A'] > 0 || alpha['A' -'A'] > 0
        || alpha['N'-'A'] > 0 || alpha['G'-'A']>0)
            return false;
        return true;
    }
}

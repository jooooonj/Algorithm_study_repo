package com.ll.삼성SW역량테스트기출.sw1230;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int ca = 0; ca < 10; ca++) {
            List<String> list = new ArrayList<>();
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                list.add(st.nextToken());
            }
            int M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                String cmd = st.nextToken();
                if (cmd.equals("I")) {
                    int index = Integer.parseInt(st.nextToken());
                    int n = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < n; j++) {
                       list.add(index+(j), st.nextToken());
                    }
                } else if (cmd.equals("D")) {
                    int index = Integer.parseInt(st.nextToken());
                    int n = Integer.parseInt(st.nextToken());
                    for(int j=0; j<n; j++){
                        list.remove(index);
                    }
                } else if (cmd.equals("A")) {
                    int n = Integer.parseInt(st.nextToken());
                    for (int j = 0; j < n; j++) {
                        list.add(list.size(), st.nextToken());
                    }
                }
            }
            sb.append("#"+(ca+1)+" ");
            for(int i=0; i<10; i++)  {
                sb.append(list.get(i)+" ");
            }

            System.out.println(sb);
            list = null;
            sb.setLength(0);
        }
    }
}


package com.ll.baekjoon.Baekjoon11723;

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

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<N; i++){
            String tmp = br.readLine();
            if (tmp.equals("empty")) {
                list.clear();
            }

            else if (tmp.equals("all")) {
                list = new ArrayList<>();
                for(int j=1; j<=20; j++){
                    list.add(j);
                }
            }

            else{
                String[] cmd = tmp.split(" ");
                int num = Integer.parseInt(cmd[1]);
                if(cmd[0].equals("add")){
                    if(!list.contains(num))
                        list.add(num);
                }

                if(cmd[0].equals("remove")){
                    if(list.contains(num))
                        list.remove(Integer.valueOf(num));
                }

                if (cmd[0].equals("check")) {
                    if(list.contains(num))
                        sb.append(1+"\n");
                    else
                        sb.append(0+"\n");
                }

                if (cmd[0].equals("toggle")) {
                    if(list.contains(num))
                        list.remove(Integer.valueOf(num));
                    else
                        list.add(num);
                }
            }
        }

        System.out.println(sb);

    }
}

package com.ll.baekjoon.Baekjoon2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        str = str.replaceAll("c=", "c");
        str =str.replaceAll("c-", "c");
        str =str.replaceAll("dz=", "c");
        str=str.replaceAll("d-", "c");
        str=str.replaceAll("lj", "c");
        str=str.replaceAll("nj", "c");
        str=str.replaceAll("s=", "c");
        str=str.replaceAll("z=", "c");

        System.out.println(str.length());
    }
}

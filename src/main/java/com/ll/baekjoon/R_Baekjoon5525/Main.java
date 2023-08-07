package com.ll.baekjoon.R_Baekjoon5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); //o가 1개일때마다 확인
        int l = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int result = 0;
        int count = 0;
        for (int i = 1; i < l - 1; i++) {
            char ch = str.charAt(i);

            //OI를 찾았다면
            if (ch == 'O' && str.charAt(i + 1) == 'I') {
                count++; //count 증가시켜주고

                if (count == N) { //count가 찾는 N값이랑 같다면
                    if (str.charAt(i - (count * 2 - 1)) == 'I') { //처음이 'I'로 시작하는지 확인해서
                        result++; //총 결과 증가
                    }
                    count--; // 맞든 아니든 N채웠으니까 앞에서부터 짤라내기
                }
                i++; //만약 OI 패턴을 찾은거라면 다음거는 건너뛰기 (어차피 'I')

            } else{
                count = 0; //OI 패턴 아니면 초기화 (다시 'OI'패턴 찾아야됨)
            }

        }
        System.out.println(result);
    }
}

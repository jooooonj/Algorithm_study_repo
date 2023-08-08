package com.ll.baekjoon.Baekjoon14719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H;
    static int W;
    static int[] map;
    static int result = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[W];
        // 빗물이 고이기 위해서는 왼쪽과 오른쪽 모두 자기보다 높은 벽이 감싸고 있어야 한다.
        // 한개의 기둥마다 별도로 계산해야 한다.
        // 왼쪽중 제일 높은거 오른쪽중 제일 높은거 찾아서 둘 중 낮은거 - 자기 높이 만큼 물고임
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        //마지막 라인은 물이 고일 수 없으므로 2~ W-1 까지 진행
        for(int i=1; i<W; i++){
            //left
            int leftMax = -1;
            for(int j=0; j<i; j++){
                if(map[j] > map[i])
                    leftMax = Math.max(leftMax, map[j]);
            }

            //right
            int rightMax = -1;
            for(int j=i+1; j<W; j++){
                if(map[j] > map[i])
                    rightMax = Math.max(rightMax, map[j]);
            }

            if(leftMax > -1  && rightMax > -1){
                int small = Math.min(leftMax, rightMax);

                if(small != -1)
                    result += (small - map[i]);
            }
        }

        System.out.println(result);

    }
}

package com.ll.baekjoon.Baekjoon8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int target;
    static class Country{
        int num;
        int gold;
        int silver;
        int guri;
        Country(int num, int gold, int silver, int guri){
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.guri = guri;
        }

        int compareTo(Country country){ //-1인 경우에만 ++
            if(this.gold > country.gold) //내 금이 더 많으면
                return 1; // 1리턴
            else if(this.gold < country.gold) //상대가 높으면
                return -1; // -1리턴
            else{ //금매달 개수 같으면
                if(this.silver > country.silver) //은매달 똑같이 비교
                    return 1;
                else if(this.silver < country.silver)
                    return -1;
                else{
                    if(this.guri >= country.guri) //동매달 내가 더 높으면 1, 같아도 1
                        return 1;
                    else
                        return -1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        Country[] countries = new Country[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int guri = Integer.parseInt(st.nextToken());

            countries[num-1] = new Country(num, gold, silver, guri);
        }

        Country curr = countries[target - 1];
        int count = 0;
        for(int i=0; i<N; i++){
            if(i==target - 1) continue;
            if(curr.compareTo(countries[i]) == -1) //나보다 높으면 count++
                count++;
        }
        System.out.println(count+1);
    }
}

package com.ll.programers.level2.p135807;

public class Main {
}

class Solution {
public int solution(int[] arrayA, int[] arrayB) {
    // 최대 공약수 구하기 -> 두 배열의 최대 공약수가 나눠지지 않으면 된다.
    // 최대 공약수의 약수들 구하기
    // 1은 제외

    int aGcd = gcdArray(arrayA);
    int bGcd = gcdArray(arrayB);

    for(int i=0; i<arrayA.length; i++){
        if(arrayA[i] % bGcd == 0){
            bGcd = 0;
            break;
        }
    }

    for(int i=0; i<arrayB.length; i++){
        if(arrayB[i] % aGcd == 0){
            aGcd = 0;
            break;
        }
    }

    System.out.println(aGcd);
    System.out.println(bGcd);

    return Math.max(aGcd, bGcd);
}

public int gcdArray(int[] array){
    int gcd = array[0];
    for(int i=1; i<array.length; i++){
        gcd = gcd(gcd, array[i]);

        if(gcd == 1) return 1;
    }

    return gcd;
}

public int gcd(int a, int b){
    if(b > a){
        return gcd(b, a);
    }

    if(b==0){
        return a;
    }

    return gcd(b, a%b);
}
}
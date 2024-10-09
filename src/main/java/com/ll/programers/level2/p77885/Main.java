package com.ll.programers.level2.p77885;

public class Main {
}
class Solution {
    public long[] solution(long[] numbers) {
        // 짝수인 경우는 마지막 bit + 1 --> 1 높은 수
        // 홀수인 경우는 최초 01 찾아서 10 으로 바꿔줘야 한다. (그 보다 뒤를 건들면 수가 작아지기 때문에)
        long[] answer = new long[numbers.length];
        for(int i=0; i<numbers.length; i++){
            long number = numbers[i];

            if(number%2==0){
                answer[i] = number + 1;
            } else {
                String bit = Long.toString(number, 2); //비트 변환 방법
                int index = bit.lastIndexOf("0"); //마지막에서부터 0이 나오는 index를 찾는다.

                if(index == -1){ //없으면
                    String tmp = "10" + bit.substring(1, bit.length());
                    answer[i] = Long.parseLong(tmp, 2);
                } else {
                    String tmp = bit.substring(0, index) + "10" + bit.substring(index + 2, bit.length());
                    answer[i] = Long.parseLong(tmp, 2);
                }
            }
        }

        return answer;
    }
}
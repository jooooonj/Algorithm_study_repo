package com.ll.programers.level2.p42860;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();

//        s.solution("LABLPAJM");
        s.solution("JAN");
//        s.solution("BMOABA");
//        s.solution("LAABAA");
//        s.solution("SAAAAAARRM");
//        s.solution("RABAMATAWADLAFAVAAE");
//        s.solution("XAAAAAABA");
//        s.solution("AYOZAAVADAY");
//        s.solution("AAFEASAAVA");
//        s.solution("UAGAAASAAFAFXZA");
//        s.solution("AAAAZAATAEA");
//        s.solution("AACALATLAHABAA");
//        s.solution("FAWJAAAFV");
//        s.solution("AACAVAAPSAAOAA");
//        s.solution("AKAAWAKX");
//        s.solution("K");
//        s.solution("W");
//        s.solution("K");
//        s.solution("X");
//        s.solution("LOAAAHAJAAFAEBAWO");
//        s.solution("BABAAAAAAB");
//        s.solution("BBBAAAAAB");
    }
}

class Solution {
    static boolean[] visited;
    static int[] counts;
    static int excludeA = 0;
    static int answer = Integer.MAX_VALUE;

    public int solution(String name) {
        //1. 알파벳 각각 해당 알파벳으로 바꾸기 위해서 몇번 조작해야 하는지
        // 0과 가까우면 위로 조작 (해당 index vs 26-해당 인덱스)
        // 더 작은 숫자로 기록
        int count = 0;
        counts = new int[name.length()];
        visited = new boolean[name.length()];

        for(int i=0; i<name.length(); i++){
            int tmp = name.charAt(i) - 'A';
            if(tmp > 0){
                counts[i] = tmp;
                excludeA++;
            }
            int index = tmp < 26-tmp ? tmp : 26-tmp;
            count += index;
        }

        if(counts[0] > 0)
            visited[0] = true;

        move(0, 0, 0);
        System.out.println(count + answer);
        return count + answer;
    }

    //해당 인덱스에서 다음 목표까지 가장 가까운 경로 재귀 (완전탐색)
    static void move(int s, int correct, int count){
        if(counts[s] > 0){
            visited[s] = true;
            correct += 1;
        }

        if(correct == excludeA){
            if(answer > count)
                answer = count;
            return;
        }

        int fCount = 1;
        int bCount = 1;

        int front = (s + 1) % counts.length;
        int back = (counts.length + (s - 1)) % counts.length;

        while(counts[front] == 0 || visited[front]) {
            front = (front + 1) % counts.length;
            fCount++;
        }
        while (counts[back] == 0 || visited[back]){
            back = (counts.length + (back - 1)) % counts.length;
            bCount++;
        }

        move(back, correct, count + bCount);
        visited[back] = false;
        move(front, correct, count + fCount);
        visited[front] = false;
    }

}

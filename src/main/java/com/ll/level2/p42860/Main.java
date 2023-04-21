package com.ll.level2.p42860;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.solution("LABLPAJM");
        s.solution("BMOABA");
        s.solution("LAABAA");
        s.solution("SAAAAAARRM");
        s.solution("RABAMATAWADLAFAVAAE");
        s.solution("XAAAAAABA");
        s.solution("AYOZAAVADAY");
        s.solution("AAFEASAAVA");
        s.solution("UAGAAASAAFAFXZA");
        s.solution("AAAAZAATAEA");
        s.solution("AACALATLAHABAA");
        s.solution("FAWJAAAFV");
        s.solution("AACAVAAPSAAOAA");
        s.solution("AKAAWAKX");
        s.solution("K");
        s.solution("W");
        s.solution("K");
        s.solution("X");
        s.solution("LOAAAHAJAAFAEBAWO");
        s.solution("BABAAAAAAB");
    }
}

class Solution {
    static int[] counts;
    static int excludeA = 0;
    static int result = Integer.MAX_VALUE;

    public int solution(String name) {
        //1. 알파벳 각각 해당 알파벳으로 바꾸기 위해서 몇번 조작해야 하는지
        // 0과 가까우면 위로 조작 (해당 index vs 26-해당 인덱스)
        // 더 작은 숫자로 기록
        int count = 0;
        counts = new int[name.length()];

        int[] counts = new int[name.length()];
        for(int i=0; i<name.length(); i++){
            int tmp = name.charAt(i) - 'A';
            if(tmp > 0){
                counts[i] = tmp;
                excludeA++;
            }
            int index = tmp < 26-tmp ? tmp : 26-tmp;
            count += index;
        }


        //2. 0을 제외한 알파벳을 다 돌기 위해서 몇번 조작해야 하는지
        //왼쪽으로/오른쪽으로 진행시켜놓고 마지막으로 0이상 숫자가 있던 인덱스 번호
        move(0,0, 0, true);
        count += result;
        System.out.println(name+" : " + count +", ");

        return count;
    }

    public void move(int index, int count, int correct, boolean zero) {
        if(correct == excludeA){
            if(result > count)
                result = count;
        }

        if(index==0 && !zero)
            return;

        int front = index;
        int back = index;
        front = (front + 1) % counts.length;
        back = (index - 1);
        if(back==-1)
            back = counts.length - 1;

        if(counts[front] > 0)
            move(front, count + 1, correct + 1, false);
        else
            move(front,count + 1, correct, false);

        if(counts[back] > 0)
            move(back, count + 1, correct + 1, false);
        else
            move(back, count+1, correct, false);
    }
}

package com.ll.level2.p172927;

public class Main {
    public static void main(String[] args) {
        int[] picks = {1, 3, 2};
        String[] minerals = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        int[] picks2 = {0,1,1};
        String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        Solution s = new Solution();

        s.solution(picks2, minerals2);
    }
}
class Solution {
    int answer = Integer.MAX_VALUE;
    int all = 0;
    public int solution(int[] picks, String[] minerals) {
        all = picks[0] + picks[1] + picks[2];

        for(int i=0; i<3; i++){
            if(picks[i] > 0){

                picks[i]--;
                find(picks, minerals, i, 0, 0, 1);
                picks[i]++;
            }
        }

        System.out.println(answer);

        return answer;
    }

    void find(int[] picks, String[] minerals, int weapon, int mineralIndex, int sum, int count){

        for(int i=mineralIndex; i<mineralIndex + 5 && i<minerals.length; i++){
            sum += calc(weapon, minerals[i]);
        }

        if(count==all || mineralIndex >= minerals.length){
            answer = Math.min(answer, sum);
        }


        for(int i=0; i<3; i++){
            if(picks[i] > 0){
                picks[i]--;
                find(picks, minerals, i, mineralIndex+5, sum, count + 1);
                picks[i]++;
            }
        }
    }

    //피로도 계산
     int calc(int weapon, String mineral){
        if(weapon == 1){
            if(mineral.equals("diamond")) return 5;
        }

        if(weapon == 2){
            if(mineral.equals("diamond")) return 25;
            if(mineral.equals("iron")) return 5;
        }

         return 1;
    }
}





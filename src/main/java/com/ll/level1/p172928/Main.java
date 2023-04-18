package com.ll.level1.p172928;

public class Main {
    public static void main(String[] args) {
        String[] park = {"SOO","OOO","OOO"};
        String[] routes = {"E 2","S 2","W 1"};

        String[] park2 = {"SOO","OXX","OOO"};
        String[] routes2 = {"E 2","S 2","W 1"};

        String[] park3 = {"OSO","OOO","OXO","OOO"};
        String[] routes3 = {"E 2","S 3","W 1"};


        Solution s = new Solution();
        s.solution(park3,routes3);

    }
}

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int R = park.length;
        int C = park[0].length();
        int[][] map = new int[R][C];
        int cr = 0;
        int cc = 0;
        for(int i=0; i<R; i++){

            for(int j=0; j<C; j++){
                if(park[i].charAt(j) == 'X')
                    map[i][j] = -100;
                if(park[i].charAt(j) == 'S'){
                    cr = i;
                    cc = j;
                }
            }
        }


        for(String cmd : routes){
            String[] split = cmd.split(" ");
            String direction = split[0];
            String number = split[1];


            int nr = cr;
            int nc = cc;
            boolean isSuccess = false;

            if(direction.equals("E")){
                for(int i=0; i<Integer.parseInt(number); i++){
                    isSuccess = false;
                    ++nc;

                    if(nc >= C)break;
                    if(map[nr][nc]<0)break;
                    isSuccess = true;
                }
            }

            else if(direction.equals("W")){
                for(int i=0; i<Integer.parseInt(number); i++){
                    isSuccess = false;
                    --nc;

                    if(nc < 0)break;
                    if(map[nr][nc]<0)break;
                    isSuccess = true;
                }
            }

            else if(direction.equals("S")){
                for(int i=0; i<Integer.parseInt(number); i++){
                    isSuccess = false;
                    ++nr;

                    if(nr >= R)break;
                    if(map[nr][nc]<0)break;
                    isSuccess = true;
                }
            }

            else{
                for(int i=0; i<Integer.parseInt(number); i++){
                    isSuccess = false;
                    --nr;

                    if(nr < 0)break;
                    if(map[nr][nc]<0)break;
                    isSuccess = true;
                }
            }

            if(isSuccess) {
                cr = nr;
                cc = nc;
            }
        }

        int[] result = {cr, cc};
        System.out.println(cr+", "+cc);
        return result;
    }
}

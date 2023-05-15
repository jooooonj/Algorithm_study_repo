package com.ll.programers.level2.p42583;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {7,4,5,6};
        int[] arr2 = {10};
        int[] arr3 = {10,10,10,10,10,10,10,10,10,10};
        int[] arr4 = {10,10};


        s.solution(100, 100, arr2);
    }
}

class Solution {
    class Truck{
        int weight;
        int dist;

        Truck(int weight, int dist){
            this.weight = weight;
            this.dist = dist;
        }

        public String toString(){
            return "["+weight+","+dist+"]";
        }
    }
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Truck> trucks = new LinkedList<>();
        for(int w : truck_weights)
            trucks.add(new Truck(w, 1));

        int time = 1;

        List<Truck> bridge = new ArrayList<>();

        Truck first = trucks.poll();
        int sum = first.weight;
        bridge.add(first);
        //다리에 트럭이 없어야지 종료
        while (!bridge.isEmpty()) {

            for(int i =0; i< bridge.size(); i++){
                Truck truck = bridge.get(i);
                truck.dist += 1;
            }
            for(int i =0; i< bridge.size(); i++){
                Truck truck = bridge.get(i);
                if(truck.dist > bridge_length){
                    sum -= truck.weight;
                    bridge.remove(i);
                }
            }

            //다리에서 내려간다 (총 무게에서도 빼준다.)


            if(!trucks.isEmpty() && sum + trucks.peek().weight <= weight){
                Truck curr = trucks.poll();
                sum += curr.weight;
                bridge.add(curr);
            }
//            for(Truck truck : bridge){
//                System.out.print(truck.toString());
//            }
            //시간은 계속 흘러간다.
            time++;
        }

        return time;
    }
}

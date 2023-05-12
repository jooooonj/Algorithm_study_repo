package com.ll.programers.level2.p64065;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String str2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String str3 = "{{20,111},{111}}";
        s.solution(str3);
    }
}

class Solution {
    public int[] solution(String s) {
        s = s.substring(1,s.length()-1);
        List<Integer[]> list = new ArrayList<>();


        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            String tmp = "";
            if(ch=='{'){
                int j = i+1;
                while(ch!='}'){
                    ch = s.charAt(j++);
                    tmp += ch;
                }
                tmp = tmp.substring(0,tmp.length() - 1);
                String[] split = tmp.split(",");
                Integer[] arr = new Integer[split.length];
                for(int c = 0; c<split.length; c++){
                    arr[c] = Integer.parseInt(split[c]);
                }
                list.add(arr);
            }
        }

        // 배열 크기 순대로 정렬
        Collections.sort(list, new Comparator<Integer[]>(){

            public int compare(Integer[] o1, Integer[] o2){
                return o1.length - o2.length;
            }
        });

        Set<Integer> set = new LinkedHashSet<>();
        Integer[] tmp = new Integer[list.get(list.size() - 1).length];
        int[] result = new int[list.get(list.size() - 1).length];

        for(Integer[] arr : list){
            for(int num : arr){
                set.add(num);
            }
        }

        tmp = set.toArray(new Integer[0]);
        for(int i=0; i<tmp.length; i++){
            result[i] = tmp[i];
        }
        return result;
    }

}


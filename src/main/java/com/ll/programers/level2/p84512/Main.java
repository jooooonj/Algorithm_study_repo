package com.ll.programers.level2.p84512;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        var word = "AAAAE";
        s.solution(word);
    }
}

class Solution {
    static String[] words = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();

    public int solution(String word) {
        int answer = 0;

        dfs("", 0);

        Collections.sort(list);

        return list.indexOf(word) + 1;
    }

    public void dfs(String str, int n) {
        list.add(str);

        if (n >= 5) {
            return;
        }

        for (int i = 0; i < 5; i++) {
            dfs(str + words[i], n + 1);
        }
    }
}

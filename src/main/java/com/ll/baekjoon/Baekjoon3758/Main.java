package com.ll.baekjoon.Baekjoon3758;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static class Log {
        int id;
        int num;
        int score;

        Log(int id, int num, int score) {
            this.id = id;
            this.num = num;
            this.score = score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
            int teamCount = Integer.parseInt(st.nextToken()); //팀의 개수
            int qCount = Integer.parseInt(st.nextToken()); //문제 개수
            int id = Integer.parseInt(st.nextToken()); //나의 팀 id
            int logCount = Integer.parseInt(st.nextToken()); // 로그 개수
            int rank = 0;

            Log[] logs = new Log[logCount];
            for (int k = 0; k < logCount; k++) {
                st = new StringTokenizer(br.readLine());
                logs[k] = new Log(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                );
            }
            //팀 식별
            Map<Integer, int[]> map = new HashMap<>();
            for (int i = 1; i <= teamCount; i++) {
                map.put(i, new int[qCount + 1]);
            }

            //점수 갱신
            for (int i = 0; i < logCount; i++) {
                int teamId = logs[i].id;
                int number = logs[i].num;
                int sc = logs[i].score;

                int[] info = map.get(teamId);
                info[number] = Math.max(sc, info[number]);
            }

            int[] myInfo = map.get(id);
            int myTotalScore = 0;
            for (int i = 1; i <= qCount; i++) { //내 총점수
                myTotalScore += myInfo[i];
            }

            //전체 팀과 비교
            for (int i = 1; i <= teamCount; i++) {
                if (i == id) continue; //자기 팀 생략

                int[] info = map.get(i);
                int totalScore = 0;
                for (int j = 1; j <= qCount; j++) {
                    totalScore += info[j];
                }

                if (myTotalScore < totalScore) rank++;
                else if (myTotalScore == totalScore) {
                    int mySubmit = 0;
                    int yourSubmit = 0;

                    for (int j = 0; j < logCount; j++) {
                        if (logs[j].id == id) mySubmit++;
                        if (logs[j].id == i) yourSubmit++;
                    }
                    if (mySubmit > yourSubmit) rank++;
                    else if (mySubmit == yourSubmit) {
                        for (int j = logCount - 1; j >= 0; j--) {
                            if (logs[j].id == id) { //우리팀이 더 끝에 있으면 진거다.
                                rank++;
                                break;
                            } else if (logs[j].id == i) { //상대팀이 더 끝에 있으면 이긴거다.
                                break;
                            }
                        }
                    }
                }
            }
            sb.append(rank + 1 + "\n");
        }
        System.out.println(sb);
    }
}


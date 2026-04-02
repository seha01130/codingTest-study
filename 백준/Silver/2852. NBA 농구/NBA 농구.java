import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        Map<Integer, Integer> winningTime = new HashMap<>();
        winningTime.put(1, 0);
        winningTime.put(2, 0);
        int[] score = new int[3];

        int lastTime = 0;
        for (int i = 0; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int team = Integer.parseInt(st.nextToken());

            String[] timeArr = st.nextToken().split(":");
            int minute = Integer.parseInt(timeArr[0]);
            int second = Integer.parseInt(timeArr[1]);
            int time = minute*60 + second;
            // System.out.println(time);

            
            if (score[1] > score[2]) winningTime.put(1, winningTime.get(1) + (time - lastTime));
            else if (score[1] < score[2]) winningTime.put(2, winningTime.get(2) + (time - lastTime));

            score[team]++;
            lastTime = time;
        }

        if (score[1] > score[2]) winningTime.put(1, winningTime.get(1) + (48*60 - lastTime));
        else if (score[1] < score[2]) winningTime.put(2, winningTime.get(2) + (48*60 - lastTime));

        int team1 = winningTime.get(1);
        int team2 = winningTime.get(2);

        int minute1 = team1/60;
        int second1 = team1%60;
        int minute2 = team2/60;
        int second2 = team2%60;

        String team1Time = String.format("%02d:%02d", minute1, second1);
        String team2Time = String.format("%02d:%02d", minute2, second2);


        sb.append(team1Time).append("\n").append(team2Time);
        System.out.println(sb);
    }
}

/*
골 넣었을 때 어느 팀이 이기게 됐는지 판별. 그리고 그 때부터 다음 골 넣은 시간동안 이긴시간에 추가.

그러려면 각 팀 별 몇점인지 기록해야하고, 각 팀 별 누직 시간 기록
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[][] timeLine = new int[N][2];
        StringTokenizer st;
        // 팀 별 득점한 시간 저장(초 수로 저장)
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            st = new StringTokenizer(str);
            int team = Integer.parseInt(st.nextToken());
            String time = st.nextToken();
            int minute = Integer.parseInt(time.split(":")[0]);
            int second = Integer.parseInt(time.split(":")[1]);

            timeLine[i][0] = team;
            timeLine[i][1] = minute*60 + second;
        }

        // System.out.println(Arrays.deepToString(timeLine));

        int[] score = new int[3];
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1,0);
        hm.put(2, 0);

        for (int i = 0; i < N; i++){
            int team = timeLine[i][0];
            score[team]++;

            // 동점이면 pass
            if (score[1] == score[2]){
                continue;
            }

            int winningTeam = score[1] > score[2] ? 1 : 2;

            int curTime;
            if (i == N-1){
                curTime = 48*60 - timeLine[i][1];
                hm.put(winningTeam, hm.getOrDefault(winningTeam, 0) + curTime);
                break;
            }

            curTime = timeLine[i+1][1] - timeLine[i][1];
            hm.put(winningTeam, hm.getOrDefault(winningTeam, 0) + curTime);
        }
        // System.out.println(hm);

        // 정렬
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((a,b) -> a.getKey().compareTo(b.getKey()));

        for (Map.Entry<Integer, Integer> entry: list){
            int time = entry.getValue();
            int minute = time / 60;
            String minuteStr = String.valueOf(minute);
            if (minute < 10) {
                minuteStr = "0" + minuteStr;
            }
            int second = time % 60;
            String secondStr = String.valueOf(second);
            if (second < 10){
                secondStr = "0" + secondStr;
            }

            sb.append(minuteStr).append(":").append(secondStr).append("\n");
        }
        
        System.out.println(sb);
    }
}

/*
N번 반복
경기시간은 48:00

현재 팀 별 점수를 기록하는 arr가 있어야함 score[2]
골 넣었을 때 이기고있는 팀에다가 시간 계산(다음골넣은시간 - 현재시간)해서 더해줌.
골 넣었을 때 동점이면 걍 continue;
마지막은 (45분 - 현재 시간) 더해줌
*/
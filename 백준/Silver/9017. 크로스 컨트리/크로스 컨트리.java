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
        while (T-- > 0){
            int N = Integer.parseInt(br.readLine());

            int[] teamSequence = new int[N];
            Map<Integer, Integer> hm = new HashMap<>();

            int sequence = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                int team = Integer.parseInt(st.nextToken());
                teamSequence[sequence++] = team;
                hm.put(team, hm.getOrDefault(team, 0) + 1);
            }
            
            HashSet<Integer> underSix = new HashSet<>();

            Iterator<Map.Entry<Integer, Integer>> itr = hm.entrySet().iterator();
            while (itr.hasNext()){
                Map.Entry<Integer, Integer> entry = itr.next();
                if (entry.getValue() < 6) underSix.add(entry.getKey());
            }

            // 등수 매기기

            Map<Integer, Integer> fourSum = new HashMap<>();
            Map<Integer, Integer> fifth = new HashMap<>();
            Map<Integer, Integer> memberCount = new HashMap<>();

            int score = 1;
            for (int i = 0; i < N; i++){
                int team = teamSequence[i];

                if (underSix.contains(team)) continue;

                int memCount = memberCount.getOrDefault(team, 0) + 1;
                memberCount.put(team, memCount);

                if (memCount <= 4) fourSum.put(team, fourSum.getOrDefault(team, 0) + score);
                else if (memCount == 5) fifth.put(team, score);

                score++;
            }

            ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(fourSum.entrySet());
            list.sort((a,b) -> {
                if (!a.getValue().equals(b.getValue())){
                    return a.getValue().compareTo(b.getValue());
                }

                return fifth.get(a.getKey()).compareTo(fifth.get(b.getKey()));
            });

            sb.append(list.get(0).getKey()).append('\n');          
        }

        System.out.println(sb);
    }
}

/*
우선 팀 들어온순서 입력받아서 저장해 -> teamSequence
    팀 별 인원수 hashmap에 저장해 (팀, 인원수) 
    만약 6명 미달이면 미달인팀 리스트에 저장해. -> underSix

teamSequence 다시 보면서 6명 이상인팀만 등수매겨
    이 때 팀 별로
        4명 합산 점수 / 5등 점수 / 현재 각 팀 별 몇 명 저장했는지
    관리해야함. 이후 다중정렬때문에 HashMap 사용함.

4명 합산 점수가 가장 작은 팀이 우승이고 만약 동점이면 5등 점수가 가장 작은 팀이 이김.
*/
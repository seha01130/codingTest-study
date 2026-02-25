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

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);

            int[] teamIds = new int[N];
            HashMap<Integer, Integer> teammatesCount = new HashMap<>();

            for (int i = 0; i < N; i++){
                teamIds[i] = Integer.parseInt(st.nextToken());
                teammatesCount.put(teamIds[i], teammatesCount.getOrDefault(teamIds[i], 0) + 1);
            }

            int rankNum = 1;
            int[] rank = new int[N];
            for (int i = 0; i < N; i++) {
                if (teammatesCount.get(teamIds[i]) == 6){
                    rank[i] = rankNum++;
                }
            }

            HashMap<Integer, Integer> fourSum = new HashMap<>();
            HashMap<Integer, Integer> fifth = new HashMap<>();
            HashMap<Integer, Integer> memberCount = new HashMap<>();

            for (int i = 0; i < N; i++) {
                if (rank[i] == 0){
                    continue;
                }
                int memCount = memberCount.getOrDefault(teamIds[i], 0) + 1;
                if (memCount == 5){
                    fifth.put(teamIds[i], rank[i]);
                } else if (memCount <= 4) {
                    fourSum.put(teamIds[i], fourSum.getOrDefault(teamIds[i], 0) + rank[i]);
                }
                memberCount.put(teamIds[i], memCount);
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
팀 순서 저장할 배열에 입력받은거 쭉 넣으면서, 팀에 대한 팀원수도 HashMap에 저장해 - teammatesCount
N만큼 돌면서 teammatesCount가 6인 팀에 대해서만 등수를 매겨. - rank

상위 4명 저장할 HashMap, 5번째 멤버 점수 저장할 HashMap, 현재 팀 별로 몇 명 저장했는지 볼 HashMap 필요함
fourSum, fifth, memberCount
N만큼 돌면서 각 팀 별로 상위 4명 점수 합산하고 (각 팀 별 몇 명 저장했는지 계속 업데이트 해줘야함) 5번째 저장할 때 fifth에 저장

상위4명 기준으로 오름차순할건데, 만약 점수가 같다면 fifth를 기준으로 정렬.
그러니까 정렬 1순위는 상위4명 점수고, 2순위는 5번째 멤버의 점수

정렬된 리스트의 맨 앞 팀이 정답
*/
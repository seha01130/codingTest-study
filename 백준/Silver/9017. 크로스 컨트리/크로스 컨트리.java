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
각 팀의 팀원이 몇명인지 구해야됨
    hashmap 써서 <팀, 팀원 수>
입력받은거 돌면서 팀원 == 6 인 팀에 대해서만 등수 매겨.

그리고 팀 별 점수들을 2차원배열에 저장하면 됨

쭉 돌면서 4명의 합을 구하고 팀, 점수  이걸 hashmap에 넣고 정렬해
만약 같은 점수가 있으면 5번째 멤버 점수끼리 비교해
*/
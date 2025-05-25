//dfs 방식으로 품

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine()); //컴퓨터 수
        int m = Integer.parseInt(br.readLine()); //연결된 쌍의 수

        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for (int i = 1; i <= n; i++){
            graph[i]  = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        // ----------------- 간선 정보 입력 완료

        // 방문여부 체크
        boolean[] visited = new boolean[n+1];

        int count = dfs(1, graph, visited, 0) - 1;
        sb.append(count);
        System.out.println(sb);
    }

    static int dfs(int node, ArrayList<Integer>[] graph, boolean[] visited, int count){
        visited[node] = true;
        count++;

        for (int next : graph[node]) {
            if (!visited[next]) { // 아직 방문 안했으면
                count = dfs(next, graph, visited, count);
            }
        }
        return count;
    }
}
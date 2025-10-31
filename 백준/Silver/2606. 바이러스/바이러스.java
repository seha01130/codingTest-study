import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        List<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }
        // 간선정보 저장 끝

        boolean[] visited = new boolean[N+1];

        int count = 0;
        count = dfs(1, graph, visited, count) - 1;

        System.out.println(count);
    }

    private static int dfs(int node, List<Integer>[] graph, boolean[] visited, int count) {
        visited[node] = true;
        count++;

        for (int next: graph[node]){
            if (!visited[next]){
                count = dfs(next, graph, visited, count);
            }
        }

        return count;
    }
}


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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];

        for (int i = 1; i <= N; i++){
            graph[i] = new ArrayList<>();
        }
       
        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }
        // ----------- 간선 저장 끝

        boolean[] visited = new boolean[N+1];

        int count = 0;

        for (int i = 1; i <= N; i++){
            if (!visited[i]){
                count++;
                dfs(i, graph, visited);
            }
        }
        

        sb.append(count);
        System.out.print(sb);
    }

    private static void dfs(int node, ArrayList<Integer>[] graph, boolean[] visited) {
        visited[node] = true;

        for(int dest: graph[node]){
            if (!visited[dest]){
                dfs(dest, graph, visited);
            }
        }

        return;
    }
}


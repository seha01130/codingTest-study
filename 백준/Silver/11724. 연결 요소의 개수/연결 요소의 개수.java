import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[N+1];
        int count = 0;

        for (int i = 1; i <= N; i++){
            if (visited[i]){
                continue;
            }

            stack.push(i);
            visited[i] = true;
            count++;

            while (!stack.isEmpty()){
                int node = stack.pop();
                for (int n : graph[node]){
                    if (!visited[n]){
                        stack.push(n);
                        visited[n] = true;
                    }
                }
            }
        }

        sb.append(count);
        System.out.println(sb);
    }
}

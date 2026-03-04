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

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[M + 1];
        for(int i = 1; i <= M; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[b].add(a);
        }

        // 간선 저장 끝

        boolean[] visited = new boolean[M+1];
        int count = 0;

        while (true) {
            if (visited[P] == true){
                count = -1;
                break;
            }
            if (graph[P].size() == 0){
                break;
            }

            visited[P] = true;
            count++;
            P = graph[P].get(0);
        }


        sb.append(count);
        System.out.println(sb);
    }
}

/*

*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
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

        int N = Integer.parseInt(br.readLine());
        String[] str = br.readLine().split(" ");
        int A = Integer.parseInt(str[0]);
        int B = Integer.parseInt(str[1]);
        int M = Integer.parseInt(br.readLine());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1;  i <= N; i++){
            graph[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0;  i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        // 부모자식 관계그래프 완성

        sb.append(bfs(N, graph, A, B));
        System.out.println(sb);
    }

    private static int bfs(int N, ArrayList<Integer>[] graph, int me, int target){
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[N+1];

        queue.offer(new int[] {me, 0});
        visited[me] = true;

        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            int person = tmp[0];
            int count = tmp[1];

            if (person == target) return count;

            for (int p : graph[person]) {
                if (visited[p]) continue;

                queue.offer(new int[] {p, count+1});
                visited[p] = true;
            }
        }

        return -1;
    }
}

/*
bfs
A 의 주변부터 연결된애들 쭉 탐색하는데 그때마다 각각에 대한 촌수 계산
최단거리 탐색과 동일함
visited 여부 당연히 체크해야하고, queue에는 현재 누군인지와, 그 사람과의 촌수를 저장
*/
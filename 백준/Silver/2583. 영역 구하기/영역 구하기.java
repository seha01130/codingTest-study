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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];

        while (K-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            for (int i = a; i < c; i++){
                for (int j = b; j < d; j++){
                    if (graph[i][j] == 1) continue;
                    graph[i][j] = 1;
                }
            }
        }
        // System.out.println(Arrays.deepToString(graph));
        // 배열 채우기 끝

        ArrayList<Integer> list = new ArrayList<>();
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int count = 0;

        for (int i = 0; i < N; i++){
            for (int j = 0; j < M; j++){
                if (graph[i][j] == 0){
                    count++;
                    list.add(bfs(graph, i, j, dr, dc));
                }
            }
        }
        sb.append(count).append("\n");

        Collections.sort(list);
        for (int i = 0; i < list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }
        
        System.out.println(sb);
    }

    private static int bfs(int[][] graph, int cr, int cc, int[] dr, int[] dc){
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;

        queue.offer(new int[]{cr, cc});
        graph[cr][cc] = 1;
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int i = 0; i < 4; i++){
                int nr = node[0]+dr[i];
                int nc = node[1]+dc[i];
                if (nr >= 0 && nc >= 0 && nr < graph.length && nc < graph[0].length && graph[nr][nc] == 0){
                    queue.offer(new int[] {nr, nc});
                    count++;
                    graph[nr][nc] = 1;
                }
            }
        }

        queue.clear();
        return count;
    }
}

/*
직사각형 내부 좌표들을 다 1로 채우자
모눈종이는 왼쪽하단이 (0,0) 이지만, 배열은 왼쪽상단이 (0,0) 이니까 편하게 계산하기 위해서 모눈종이를 시계방향으로 90도 돌려서
배열과 같이 계산할 수 있게 생각하자. 그럼 배열 크기도 [N][M]이 되겠지.

어차피 영역의 개수와 크기를 구하는거니까 이렇게 생각해도 상관없음! 결과는 같음!

쭉 훑으면서 0인곳있으면 거기부터 이제 탐색 시작
bfs로 탐색해보자
*/
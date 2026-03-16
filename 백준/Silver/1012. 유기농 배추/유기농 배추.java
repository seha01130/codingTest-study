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

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int Col = Integer.parseInt(st.nextToken());
            int Row = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] graph = new int[Row][Col];
            int[] dr = new int[] {0, 1, 0, -1};
            int[] dc = new int[] {1, 0, -1, 0};

            int count = 0;

            for (int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                graph[r][c] = 1;
            }
            // System.out.println(Arrays.deepToString(graph));
            // 입력받기 완료

            for (int i = 0; i < Row; i++){
                for (int j = 0; j < Col; j++){
                    if (graph[i][j] == 0) continue;
                    count++;

                    bfs(graph, i, j, dr, dc, Row, Col);
                }
            }
            sb.append(count).append("\n");
        }
        
        System.out.println(sb);
    }

    private static void bfs(int[][] graph, int i, int j, int[] dr, int[] dc, int Row, int Col){
        Queue<int[]> queue = new LinkedList<>();
        graph[i][j] = 0;
        queue.offer(new int[] {i, j}); // 현재 row, col 저장

        while (!queue.isEmpty()){
            int[] node = queue.poll();
            int cr = node[0];
            int cc = node[1];

            for (int d = 0; d < 4; d++){
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if (nr < 0 || nc < 0 || nr >= Row || nc >= Col || graph[nr][nc] == 0) continue;

                graph[nr][nc] = 0; // 방문표시
                queue.offer(new int[] {nr, nc});
            }
        }
    }
}

/*
bfs
오른쪽 -> 아래 -> 왼쪽 -> 위 순서대로 돌아가면서 검사
구역의 갯수를 구하면 그게 곧 배추흰지렁이의 갯수이다.

(0,0) 부터 시작하면서 검사 -> 1 마주치면 검사시작
검사하면 0으로 변경 (방문했다는 뜻)
*/
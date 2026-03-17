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

        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        int[][] graph = new int[N][M];

        for (int i = 0; i < N; i++){
            char[] charArr = br.readLine().toCharArray();
            for (int j = 0; j < M; j++){
                graph[i][j] = charArr[j] - '0';
            }
        }
        // System.out.println(Arrays.deepToString(graph));
        // 입력받기 완료

        int[] dr = new int[] {0, 1, 0, -1};
        int [] dc = new int[] {1, 0, -1, 0};

        sb.append(bfs(graph, 0, 0, dr, dc, N-1, M-1));
        System.out.println(sb);
    }

    private static int bfs(int[][] graph, int startR, int startC, int[] dr, int[] dc, int finishR, int finishC) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 1;
        queue.offer(new int[] {startR, startC, count});
        graph[startR][startC] = 0;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int cr = info[0];
            int cc = info[1];
            count = info[2];

            if (cr == finishR && cc == finishC){
                return count;
            }

            for (int i = 0; i < 4; i++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if (nr < 0 || nc < 0 || nr > finishR || nc > finishC || graph[nr][nc] == 0) continue;

                queue.offer(new int[] {nr, nc, count + 1});
                graph[nr][nc] = 0;
            }
        }

        return count;
    }
}

/*
bfs - 최단거리

오른쪽 -> 아래 -> 왼쪽 -> 위 방향으로 순회하며 검사
Queue 자료구조에는 현재 배열의 r, c값과 (0,0) 으로부터 몇칸 떨어져있는지를 센 count 값을 저장
(다음 칸은 이전 칸의 count 수에 +1을 한 값과 같다)
방문했으면 0으로 값 변경하기
*/
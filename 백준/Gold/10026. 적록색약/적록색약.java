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
        char[][] normgraph = new char[N][N];
        char[][] notgraph = new char[N][N];
        HashMap<Character, Integer> normhm = new HashMap<>();
        HashMap<Character, Integer> nothm = new HashMap<>();

        for (int i = 0; i < N; i++){
            char[] arr = br.readLine().toCharArray();
            normgraph[i] = arr;
        }

        for (int i = 0; i < N; i++){
            notgraph[i] = normgraph[i].clone();
            for (int j = 0; j < N; j++){
                if (notgraph[i][j] == 'G'){
                    notgraph[i][j] = 'R';
                }
            }
        }

        // System.out.println(Arrays.deepToString(normgraph));
        // System.out.println(Arrays.deepToString(notgraph));
        // 색 배열 입력 완료

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        // 정상인
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (normgraph[i][j] == 'O') continue;

                char color = normgraph[i][j];
                bfs(normgraph, color, i, j, dr, dc);
                normhm.put(color, normhm.getOrDefault(color, 0) + 1);
            }
        }
        // System.out.println(normhm);

        // 적록색약인
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (notgraph[i][j] == 'O') continue;

                char color = notgraph[i][j];
                bfs(notgraph, color, i, j, dr, dc);
                nothm.put(color, nothm.getOrDefault(color, 0) + 1);
            }
        }
        // System.out.println(nothm);

        int norm = normhm.getOrDefault('R', 0) + normhm.getOrDefault('G', 0) + normhm.getOrDefault('B', 0);
        int not = nothm.getOrDefault('R', 0) + nothm.getOrDefault('B', 0);

        sb.append(norm).append(" ").append(not);
        System.out.println(sb);
    }

    private static void bfs(char[][] graph, char color, int cr, int cc, int[] dr, int[] dc) {
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[] {cr, cc});
        graph[cr][cc] = 'O';

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            for(int i = 0; i < 4; i++){
                int nr = node[0]+dr[i];
                int nc = node[1]+dc[i];

                if (nr >= 0 && nc >= 0 && nr < graph.length && nc < graph[0].length && graph[nr][nc] == color){
                    queue.offer(new int[] {nr, nc});
                    graph[nr][nc] = 'O';
                }
            }
        }
        return;
    }
}

/*
NxN 배열에 입력을 받아 (정상인, 적록색상인 따로 - 적록색상인은 G을 R로 치환)
hm 으로 색깔 별 구역 갯수 카운드 (정상인, 적록색상인 따로)

각각
(0,0) 부터 for문 돌면서 탐색
색 있는 부분(O아닌 부분) 발견하면 거기부터 bfs로 탐색. 색깔구역++하기. 탐색했으면 거기를 O로 바꾸기.
*/
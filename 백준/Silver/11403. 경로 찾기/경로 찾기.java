import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        // 1. 입력: 인접 행렬을 그대로 배열에 저장
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 2. 플로이드-워셜 알고리즘 (3중 for문)
        // k: 거쳐가는 노드 (반드시 가장 바깥 루프여야 함!)
        for (int k = 0; k < N; k++) {
            // i: 출발 노드
            for (int i = 0; i < N; i++) {
                // j: 도착 노드
                for (int j = 0; j < N; j++) {
                    // i에서 k로 갈 수 있고, k에서 j로 갈 수 있다면?
                    // i에서 j로 갈 수 있다는 뜻! (1로 업데이트)
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        // 3. 출력: 업데이트된 행렬 출력
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(graph[i][j]).append(" ");
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
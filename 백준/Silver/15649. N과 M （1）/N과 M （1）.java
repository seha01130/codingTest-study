import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] result = new int[M]; // 0 ~ (M - 1)
        boolean[] visited = new boolean[N + 1]; // 1 ~ N

        backtrack(N, M, 0, result, visited);

        System.out.println(sb);
    }

    public static void backtrack(int N, int M, int depth, int[] result, boolean[] visited){
        if (depth == M){
            //출력
            for (int i = 0; i < M; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = 1; i <= N; i++){
            // 아직 그 숫자가 사용이 안됨
            if (!visited[i]) {
                result[depth] = i;
                visited[i] = true;
                backtrack(N, M, depth + 1, result, visited);
                visited[i] = false;
            }

            // return;

            //이 return문이 있으면 result[0]에 1을 넣고나서 visited[1] 을 true로 만들고나서 backtrack을 한 번 더 타면 
            // result[1]을 검사하게되는데 이미 1은 true니까 if문에 안걸리고
            // 바로 return돼서 visited[1] 을 false로 만들고나서 main함수로 리턴돼서 그대로 끝남.
        }
    }
}
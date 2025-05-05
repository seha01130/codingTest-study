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

        int[] result = new int[M];
        int flagNum = 1;
        int depth = 0;

        dfs(N, M, depth, result, flagNum);

        System.out.println(sb);
    }

    public static void dfs(int N, int M, int depth, int[] result, int flagNum){
        // result가 다 찼으면 출력
        if (depth == M) {
            for (int i = 0; i < M; i++){
                sb.append(result[i] + " ");
            }
            sb.append("\n");

            // return 하는거 빼먹으면 안됨!!!
            return;
        }

        for (int i = flagNum; i <= N; i++){
            // if (i >= flagNum){
                result[depth] = i;
                flagNum = i;
                dfs(N, M, depth + 1, result, flagNum + 1);
                // flagNum = result[depth]
            // }
        }
    }
}
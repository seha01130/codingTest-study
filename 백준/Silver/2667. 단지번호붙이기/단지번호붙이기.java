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

        int N = Integer.parseInt(br.readLine());
        int[][] graph = new int[N][N];

        String str;
        for (int i = 0; i < N; i++){
            str = br.readLine();
            char[] arr = str.toCharArray();
            for (int j = 0; j < N; j++){
                graph[i][j] = arr[j] - '0';
            }
        }
        // 숫자 넣기 완료

        int[] rotateRow = {0, 1, 0, -1};
        int[] rotateCol = {1, 0, -1, 0};

        int count = 0;
        ArrayList<Integer> house = new ArrayList<>();
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                if (graph[i][j] == 0) continue;
                count++;
                int h = 1;

                h = bt(graph, rotateRow, rotateCol, i, j, N);
                house.add(h);
            }
        }

        sb.append(count).append("\n");

        house.sort((a,b) -> a.compareTo(b));
        for (int i = 0; i < house.size(); i++){
            sb.append(house.get(i)).append("\n");
        }

        System.out.println(sb);
    }

    private static int bt(int[][] graph, int[] rotateRow, int[] rotateCol, int row, int col, int N) {
        if (row < 0 || col < 0 || row >= N || col >= N || graph[row][col] == 0) return 0;
        graph[row][col] = 0;
        int count = 1;

        for (int k = 0; k < 4; k++){
            count += bt(graph, rotateRow, rotateCol, row + rotateRow[k], col + rotateCol[k], N);
        }

        return count;
    }
}

/*
(0,0) ~ (N,N) 확인하면서 1인 좌표에서 시작.
오른쪽 -> 아래 -> 왼쪽 -> 위  순서대로 탐색
탐색한 부분이 1이면 그 위치로 가서 또 다시 탐색. 이 떄 탐색했다는 의미로 숫자를 0으로 변경해줌.
만약 탐색해도 1이 없으면 백트래킹 됨
*/
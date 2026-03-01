import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int targetNum = Integer.parseInt(br.readLine());
        
        int[][] arr = new int[N][N];
        int[] dr = {1, 0, -1, 0}; //directionRow
        int[] dc = {0, 1, 0, -1}; //directionCol

        int num = N*N;

        int cr = 0; //currentRow
        int cc = 0; //currentCol
        int dir = 0;
        
        while (num > 0){
            if(targetNum == num){
                sb.append(cr+1).append(" ").append(cc+1);
            }

            arr[cr][cc] = num--;
            
            int nr = cr + dr[dir]; //nextRow
            int nc = cc + dc[dir]; //nextCol

            // 방향전환
            if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1 || arr[nr][nc] != 0){
                dir = (dir + 1) % 4;
                nr = cr + dr[dir];
                nc = cc + dc[dir];
            }

            cr = nr;
            cc = nc;
        }

        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        
        System.out.println(sb);
    }
}

/*
N*N 개의 이차원 배열 만들고
[0][0] 부터 시작 -> N*N 수 부터 시작하면서 최종 1일때까지 -- 해나갈건데
아래 -> 오른쪽 -> 위 -> 왼쪽  방향순으로 반복
    아래: index가 row는 +1, col은 그대로   -> 변화값: 1 0
    오른쪽: index가 row는 그대로, col은 +1  -> 변화값: 0 1
    위: index가 row는 -1, col은 그대로     -> 변화값: -1 0
    왼쪽: index가 row는 그대로, col은 -1    -> 변화값: 0 -1
index가 0보다 작거나 N보다 크거나 값이0이 아니면 방향 전환

주어진 자연수 마주치면 좌표 저장
*/
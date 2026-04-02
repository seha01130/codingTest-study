import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
        int target = Integer.parseInt(br.readLine());

        int[][] arr = new int[N][N];
        int currentR = N/2;
        int currentC = N/2;
        arr[currentR][currentC] = 1;
        int num = 2;

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        // target 숫자가 1일때도 고려하여 초기화
        int targetR = currentR + 1;
        int targetC = currentC + 1;
        for (int i = 0; i < N/2; i++){
            currentR = currentR-1;
            currentC = currentC-1;

            for (int k = 0; k < 4; k++){
                for (int j = 0; j < 2 * (i+1); j++){
                    arr[currentR+dr[k]][currentC+dc[k]] = num;
                    currentR = currentR+dr[k];
                    currentC = currentC+dc[k];

                    if (num == target){
                        targetR = currentR + 1;
                        targetC = currentC + 1;
                    }
                    num++;
                }
            }
        }
        // System.out.println(Arrays.deepToString(arr));
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.append(targetR).append(" ").append(targetC);
        
        System.out.println(sb);
    }
}

/*
오른쪽 -> 아래 -> 왼쪽 -> 위  방향으로 숫자 채워넣음
처음에는 2칸씩 연속으로 채워넣고 그다음은 4칸씩. 2의 배수씩 연속으로 채워넣는다.

1은 (N/2, N/2) 좌표
빙글 도는 시작은 위 좌표에서 한 칸 위로 올라간 좌표에서 시작.
-> 배열처럼 부터 시작한다고 가정하자. 나중에 좌표 위치 출력할때 +1 해서 출력하면 됨.
*/
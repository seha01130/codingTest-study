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
        int[] inputArr = new int[N+1];
        int[] answerArr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++){
            int tallerNum = inputArr[i];
            int count = 0;
            for (int j = 1; j <= N; j++){
                if (answerArr[j] != 0) continue;
                if (tallerNum == count){
                    answerArr[j] = i;
                }
                count++;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(answerArr[i]).append(" ");
        }

        
        System.out.println(sb);
    }
}

/*
1번 방법
n개의 배열 마련해놓고
키 작은사람부터 확인하면서 자기보다 큰 사람의 수만큼 빈 공간 두고 그 다음칸에 넣기.
앞으로 확인할 사람은 나보다 큰 사람이니까 그 사람이 들어갈 공간을 앞에 둬놓는거야.

2번 방법

*/
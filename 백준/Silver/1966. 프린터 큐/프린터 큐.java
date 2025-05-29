import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); //문서의 갯수
            int M = Integer.parseInt(st.nextToken()); //궁금한 문서의 현재 순서

            Queue<int[]> queue = new LinkedList<>();
            PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());

            st = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++){
                int idx = i;
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[] {idx, priority});
                pQueue.add(priority);
            }
            // 큐에 인덱스/중요도 삽입, 우선순위큐에 중요도 삽입 완료

            int count = 0;
            while (!queue.isEmpty()){
                int[] current = queue.poll();
                int idx = current[0];
                int priority = current[1];

                if (priority == pQueue.peek()){
                    pQueue.poll();
                    count++;
                    if (idx == M){
                        break;
                    }
                } else {
                    queue.add(current);
                }
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
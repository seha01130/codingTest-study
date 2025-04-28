import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();

        // String str = br.readLine();
        // int N = Integer.parseInt(str.charAt(0) + "");

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            deque.addLast(i + 1);
        }
        // System.out.println(deque);

        sb.append("<");
        int count = 1;
        while (!deque.isEmpty()){
            if (count < K){
                deque.addLast(deque.removeFirst());
                count++;
            } else {
                sb.append(deque.removeFirst());
                count = 1;

                if (!deque.isEmpty()){
                    sb.append(", ");
                }
            }
        }
        sb.append(">");

        System.out.println(sb);
    }
}
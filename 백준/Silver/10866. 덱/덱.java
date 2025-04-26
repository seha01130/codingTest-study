import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());

        String type;
        int num = 0;
        for (int i = 0; i < N; i++){

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            type = st.nextToken();
            if (st.hasMoreTokens()){
                num = Integer.parseInt(st.nextToken());
            }

            switch(type){
                case "push_front":
                    deque.addFirst(num);
                    break;
                case "push_back":
                    deque.addLast(num);
                    break;
                case "pop_front":
                    if (deque.isEmpty()){
                        sb.append(-1);
                    } else {
                        sb.append(deque.removeFirst());
                    }
                    break;
                case "pop_back":
                    if (deque.isEmpty()){
                        sb.append(-1);
                    } else {
                        sb.append(deque.removeLast());
                    }
                    break;
                case "size":
                    sb.append(deque.size());
                    break;
                case "empty":
                    if (deque.isEmpty()){
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    break;
                case "front":
                    if (deque.isEmpty()){
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekFirst());
                    }
                    break;
                case "back":
                    if (deque.isEmpty()){
                        sb.append(-1);
                    } else {
                        sb.append(deque.peekLast());
                    }
                    break;
                default:
                    break;
            }

            if (!type.equals("push_front") && !type.equals("push_back") && i < N - 1){
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
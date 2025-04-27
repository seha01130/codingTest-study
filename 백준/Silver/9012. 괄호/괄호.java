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

        Deque<Character> deque = new ArrayDeque<>();

        int T = Integer.parseInt(br.readLine());
        String str;

        for (int i = 0; i < T; i++){
            str = br.readLine();

            for (int j = 0; j < str.length(); j++){
                if (str.charAt(j) == '('){
                    deque.addLast(str.charAt(j));
                } else if (deque.isEmpty() && str.charAt(j) == ')'){
                    deque.addLast(str.charAt(j));
                    break;
                } else {
                    deque.removeLast();
                }
            }

            sb.append(deque.isEmpty() ? "YES" : "NO");
            deque.clear();

            if (i < T - 1){
            sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            char[] array = br.readLine().toCharArray();
            Deque<Character> deque = new ArrayDeque<>(); // Deque 사용

            for (char ch : array) {
                if (!deque.isEmpty() && deque.peekLast() == ch) {  // 맨 뒤 요소와 현재가 같으면 pop
                    deque.removeLast();
                } else {
                    deque.addLast(ch);  // 맨 뒤에 push
                }
            }

            if (deque.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}
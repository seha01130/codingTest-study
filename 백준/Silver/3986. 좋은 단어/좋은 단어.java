import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            Stack<Character> stack = new Stack<>();

            for (char ch : word.toCharArray()) {
                if (!stack.isEmpty() && stack.peek() == ch) {
                    stack.pop();  // 짝을 이뤘으면 제거
                } else {
                    stack.push(ch);  // 새 문자 넣기
                }
            }

            if (stack.isEmpty()) {
                count++;
            }
        }

        System.out.println(count);
    }
}

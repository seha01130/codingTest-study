import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        String input = br.readLine();
        char[] list = input.toCharArray();
        Deque<Character> queue = new ArrayDeque<>();

        int tag = 0;
        for (int i = 0; i < list.length; i++) {
            Character c = list[i];

            if (c == '<' && tag == 0) {
                while (!queue.isEmpty()) {
                    sb.append(queue.pop());
                }
                answer.append(sb.toString());
                sb.setLength(0);

                queue.addLast(c);
                tag = 1;
                continue;
            }

            if (tag == 1 && c == '>') {
                queue.addLast(c);
                while (!queue.isEmpty()) {
                    sb.append(queue.pop());
                }
                tag = 0;
                answer.append(sb.toString());
                sb.setLength(0);
                continue;
            }

            if (tag == 1) {
                queue.addLast(c);
                continue;
            }

            if (tag == 0 && c == ' ') {
                while (!queue.isEmpty()) {
                    sb.append(queue.pop());
                }
                answer.append(sb.toString()).append(' ');
                sb.setLength(0);
                continue;
            }

            queue.addFirst(c);
        }

        while (!queue.isEmpty()) {
            sb.append(queue.pop());
        }
        answer.append(sb.toString());

        System.out.println(answer);
    }
}

/*
 * 태그 들어가면 tag = 1;
 * < 만나면 deque에 넣고 > 만날때까지 계속 넣다가 > 만나면 순서대로 꺼냄
 * 
 * 태그 아닐떄는 tag = 0
 * 넣다가 공백 만나거나 < 만나면 거꾸로 꺼냄
 */
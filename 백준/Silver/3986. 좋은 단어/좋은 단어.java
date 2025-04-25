import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++){
            char[] array = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();

            for (char ch : array){
                if (!stack.isEmpty() && stack.peek() == ch){
                    stack.pop();
                } else{
                    stack.push(ch);
                }
            }

            if (stack.isEmpty()){
                count++;
            }
        }

        System.out.println(count);
    }
}
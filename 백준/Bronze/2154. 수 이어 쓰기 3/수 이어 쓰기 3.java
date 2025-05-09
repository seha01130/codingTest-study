import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++){
            sb.append(i);
        }

        int result = sb.indexOf(String.valueOf(N)) + 1;
        // int result2 = sb.indexOf(Integer.toString(N)) + 1;

        System.out.println(result);
        // System.out.println(result2);
    }
}
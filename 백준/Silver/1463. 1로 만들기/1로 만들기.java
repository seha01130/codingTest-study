import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] memo = new int[N + 1];
        
        memo[1] = 0;

        for (int i = 2; i <= N; i++){
            memo[i] = memo[i-1]+1;
            if (i % 3 == 0){
                memo[i] = Math.min(memo[i/3] + 1, memo[i]);
            }
            if (i % 2 == 0){
                memo[i] = Math.min(memo[i/2] + 1, memo[i]);
            }
        }

        System.out.println(memo[N]);

    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        long digitSum = 0;
        for (int i = 1; i <= N; i++){
            digitSum += getDigits(i);
        }

        sb.append(digitSum);
        System.out.println(sb);
    }

    public static int getDigits(int num){
        int count = 0;
        while (num != 0){
            count++;
            num /= 10;
        }
        return count;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // x자리수 // 1 2 3 ... 이렇게  ++ 하면서 증가해야함
        int length = 1;

        // 1 10 100 1000 이렇게 10씩 곱하면서 커짐
        int start = 1;

        long result = 0;

        while (start * 10 - 1 <= N){ 
            result += length * (start * 9); //자리수갯수 * 해당자리수에 존재하는 숫자갯수
            length++;
            start *= 10;
        }

        result += length * (N - start + 1);

        System.out.println(result);
    }
}


// 1 ~ 9 : 9개
// 10 ~ 99 : 90개
// 100 ~ 999 : 900개

// 102 -> 100 ~ 102 -> 3개 -> 102 - 100 + 1
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        int[] arr = new int[9];
        for (int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] result = new int[7];
        sub(arr, result, 0, 0);

        System.out.println(sb);

    }

    public static boolean sub(int[] arr, int[] result, int depth, int idx) {
        if (depth == 7){
            int sum = 0;
            for (int i = 0; i < result.length; i++){
                sum += result[i];
            }
            if (sum == 100){
                Arrays.sort(result);
                for (int i = 0; i < 7; i++){
                    sb.append(result[i] + "\n");
                }
                return true;
            } else {
                return false;
            }
        }

        for (int i = idx; i < arr.length; i++){
            result[depth] = arr[i];
            if (sub(arr, result, depth + 1, i + 1)) {
                return true; // 하위 호출에서 조건 만족 → 상위에서도 종료
            }
        }
        return false;
    }
}
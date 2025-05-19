import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        boolean flag = false;
        for (int i = 0; i < 8 && !flag; i++){
            for (int j = i + 1; j < 9; j++){
                if (sum - arr[i] - arr[j] == 100){
                    flag = true;
                    
                    arr[i] = 0;
                    arr[j] = 0;

                    Arrays.sort(arr);
                    break;
                }
            }
        }

        for (int i = 2; i < 9; i++){
            System.out.println(arr[i]);
        }

    }
}
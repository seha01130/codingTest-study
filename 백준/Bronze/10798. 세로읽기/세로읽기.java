import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[][] arr = new char[5][];
        int maxLength = 0;
        for (int i = 0; i < 5; i++){
            char[] charArr = br.readLine().toCharArray();
            if (maxLength < charArr.length){
                maxLength = charArr.length;
            }
            arr[i] = charArr;
        }

        // System.out.println(Arrays.deepToString(arr));


        for (int i = 0; i < maxLength; i++){
            for (int j = 0; j < 5; j++){
                if (i < arr[j].length){
                    sb.append(arr[j][i]);
                }
            }
        }

        System.out.println(sb);
    }
}

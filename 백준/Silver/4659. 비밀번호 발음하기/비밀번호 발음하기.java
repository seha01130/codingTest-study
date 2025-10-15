import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashSet<Character> hs = new HashSet<Character>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int[] flag = new int[] { 0, 1, 1 };

        int thirdFlag = 0;
        int count = 0;

        String input = br.readLine();
        while (!input.equals("end")) {

            flag = new int[] { 0, 1, 1 };
            char[] arr = input.toCharArray();
            count = 1;

            for (int i = 0; i < arr.length; i++) {
                // 처음 조건
                if (hs.contains(arr[i]) && flag[0] == 0) {
                    flag[0] = 1;
                }

                // 두 번째 조건
                if (i == 0){
                    if(hs.contains(arr[i])){
                        thirdFlag = 0;
                    }else {
                        thirdFlag = 1;
                    }
                }
                
                if (i > 0) {
                    if (hs.contains(arr[i]) && thirdFlag == 0) {
                        count++;
                        if (count == 3) {
                            flag[1] = 0;
                            break;
                        }
                    } else if (hs.contains(arr[i]) && thirdFlag == 1) {
                        count = 1;
                        thirdFlag = 0;
                    } else if (!hs.contains(arr[i]) && thirdFlag == 0) {
                        count = 1;
                        thirdFlag = 1;
                    } else {
                        count++;
                        if (count == 3) {
                            flag[1] = 0;
                            break;
                        }
                    }
                }

                // 세 번째 조건
                if (i > 0 && (arr[i] == arr[i - 1]) && (arr[i] != 'e') && (arr[i] != 'o')) {
                    flag[2] = 0;
                    break;
                }

            }

            sb.append("<").append(input).append(">").append(" is");
            if (!(flag[0] == 1 && flag[1] == 1 && flag[2] == 1)) {
                sb.append(" not");
            }
            sb.append(" acceptable.").append("\n");

            input = br.readLine();
        }
        System.out.println(sb);
    }
}

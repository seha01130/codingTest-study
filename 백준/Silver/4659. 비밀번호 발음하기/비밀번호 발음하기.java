import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static String VOWELS = "aeiou";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        while (!input.equals("end")) {

            int[] flag = new int[] { 0, 1, 1 };
            int countV = 0;
            int countC = 0;

            for (int i = 0; i < input.length(); i++) {
                char currentChar = input.charAt(i);

                if (VOWELS.indexOf(currentChar) != -1) { // 모음이면
                    flag[0] = 1;
                    countV++;
                    countC = 0;
                } else { // 자음이면
                    countC++;
                    countV = 0;
                }

                if (countV == 3 || countC == 3){
                    flag[1] = 0;
                    break;
                }

                if (i > 0 && currentChar == input.charAt(i-1)){
                    if (currentChar != 'e' && currentChar != 'o'){
                        flag[2] = 0;
                        break;
                    }
                }

            }

            sb.append("<").append(input).append("> is");
            if (flag[0] == 0 || flag[1] == 0 || flag[2] == 0){
                sb.append(" not");
            }
            sb.append(" acceptable.\n");

            input = br.readLine();

        }
        System.out.println(sb);
    }
}

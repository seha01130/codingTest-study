import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = 0;
        int i = 1;
        int flag = 0;

        while (st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if (n == 1 && flag == 0){
                sum += i;
                i++;
                flag = 1;
            } else if (n == 1 && flag == 1) {
                sum += i;
                i++;
            }else {
                i = 1;
                flag = 0;
            }
        }

        sb.append(sum);
        System.out.println(sb);
    }
}

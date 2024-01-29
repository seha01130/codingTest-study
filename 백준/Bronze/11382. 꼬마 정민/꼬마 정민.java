import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception {
        long sum = 0;
        long[] arr = new long[3];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i = 0; i < 3; i++){
            arr[i] = Long.parseLong(st.nextToken());
            sum += arr[i];
        }
        sb.append(sum).append('\n');
        br.close();

        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int a, b;
        for (int i = 0; i < T ; i++){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            sb.append(getLCA(a, b) * 10).append("\n");
        }

        System.out.println(sb);
    }

    public static int getLCA(int a, int b){
        while (a != b){
            if (a > b){
                a /= 2;
            } else {
                b /= 2;
            }
        }

        return a;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        int[] answer = new int[N];
        int[][] std = new int[N][2];

        StringTokenizer st;
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            std[i][0] = w;
            std[i][1] = h;
        }

        int count = 0;
        for (int i = 0; i < N; i++){
            int weight = std[i][0];
            int height = std[i][1];

            count = 0;
            for (int j = 0; j < N; j++){
                if (std[j][0] > weight && std[j][1] > height){
                    count++;
                }
            }
            sb.append(count+1).append(" ");
        }


        System.out.println(sb);
    }
}

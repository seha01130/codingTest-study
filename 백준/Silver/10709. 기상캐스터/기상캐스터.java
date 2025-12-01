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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        char [][] input = new char[H][W];
        int [][] answer = new int[H][W];

        for (int i = 0; i < H; i++){
            char[] arr = br.readLine().toCharArray();
            for (int j = 0; j < W; j++){
                input[i][j] = arr[j];
            }
        }

        int cloud;
        for (int i = 0; i < H; i++){
            cloud = 0;
            for (int j = 0; j < W; j++){
                char now = input[i][j];
                if (now == '.' && cloud == 0){
                    answer[i][j] = -1;
                    continue;
                }
                
                if (now == 'c'){
                    cloud = 1;
                    answer[i][j] = 0;
                    continue;
                }

                answer[i][j] = cloud;
                cloud++;
            }
        }

        for (int i = 0; i < H; i++){
            for (int j = 0; j < W; j++){
                sb.append(answer[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

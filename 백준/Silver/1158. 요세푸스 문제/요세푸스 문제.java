import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list =  new LinkedList<>();
        for (int i = 1; i <= N; i++){
            list.add(i);
        }

        sb.append('<');
        while (list.size() != 0) {
            for (int i = 0; i < K; i++) {
                if (i != (K - 1)) {
                    list.add(list.remove());
                } else {
                    if (list.size() != 1) {
                        sb.append(list.remove()).append(", ");
                    } else {
                        sb.append(list.remove());
                    }
                }
            }
        }
        sb.append('>');

        System.out.println(sb);
    }
}

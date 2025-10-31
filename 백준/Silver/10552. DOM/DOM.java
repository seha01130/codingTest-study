import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[M+1];
        for(int i = 1; i <= M; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int like = Integer.parseInt(st.nextToken());
            int hate = Integer.parseInt(st.nextToken());

            graph[hate].add(like);
        }

        // 정리 완료

        boolean[] visited = new boolean[M+1];
        int count = 0;
        int currentChannel = P;
        while(true){
            if (visited[currentChannel]){
                count = -1;
                break;
            }

            if (graph[currentChannel].size() == 0){
                break;
            }

            visited[currentChannel] = true;
            
            currentChannel = graph[currentChannel].get(0);
            count++;
        }
        
        System.out.println(count);
    }
}


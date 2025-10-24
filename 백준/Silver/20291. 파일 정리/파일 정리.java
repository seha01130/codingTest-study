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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Map<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine(), ".");
            st.nextToken();
            String ext = st.nextToken();

            hm.put(ext, hm.getOrDefault(ext, 0) + 1);
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((a, b) -> a.getKey().compareTo(b.getKey()));

        for(Map.Entry<String, Integer> entry: list){
            sb.append(entry.getKey()).append(' ').append(entry.getValue()).append('\n');
        }

        System.out.println(sb);
    }
}

/*
 * 
 */
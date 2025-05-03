import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> hm = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        String str = "";
        for (int i = 0; i < N; i++){
            str = br.readLine();

            if (!hm.keySet().contains(str)){
                hm.put(str, 1);
            } else {
                int count = hm.get(str);
                hm.replace(str, count + 1);
            }
        }

        //key기준 알파벳 오름차순 정렬
        List<Map.Entry<String, Integer>> list = new ArrayList<>(hm.entrySet());
        // list.sort(Comparator.comparing(Map.Entry::getKey));
        list.sort((a, b) -> a.getKey().compareToIgnoreCase(b.getKey()));

        int maxCount = -1;
        String answer = "";
        for (Map.Entry<String, Integer> entry : list){
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                answer = entry.getKey();
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }
}
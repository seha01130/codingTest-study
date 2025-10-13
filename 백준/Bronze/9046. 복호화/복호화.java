import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String input = br.readLine();

            HashMap<Character, Integer> hm = new HashMap<>();

            for (char word : input.toCharArray()){
                if (word == ' ') continue;
                hm.put(word, hm.getOrDefault(word, 0) + 1);
            }

            List<Map.Entry<Character, Integer>> list = new ArrayList<>(hm.entrySet());
            list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));
            // System.out.println(list.toString());

            Map.Entry<Character, Integer> first = list.get(0);

            if (list.size() == 1) {
                sb.append(first.getKey());
            } else {
                Map.Entry<Character, Integer> second = list.get(1);

                if (first.getValue() == second.getValue()) {
                    sb.append('?');
                } else {
                    sb.append(first.getKey());
                }
            }

            sb.append('\n');

        }

        System.out.println(sb);
    }
}

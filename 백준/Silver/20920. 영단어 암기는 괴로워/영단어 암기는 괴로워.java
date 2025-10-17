import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (word.length() < M) {
                continue;
            }
            hm.put(word, hm.getOrDefault(word, 0) + 1);
        }

        ArrayList<String> words = new ArrayList<>(hm.keySet());

        words.sort((word1, word2) -> {
            // 조건 1: 빈도수 내림차순
            int freqCompare = hm.get(word2).compareTo(hm.get(word1));
            if (freqCompare != 0)
                return freqCompare;

            // 조건 2: 길이 내림차순
            int lenCompare = Integer.compare(word2.length(), word1.length());
            if (lenCompare != 0)
                return lenCompare;

            // 조건 3: 알파벳 오름차순
            return word1.compareTo(word2);
        });

        for (String s : words) {
            sb.append(s).append("\n");
        }

        System.out.print(sb);
    }
}

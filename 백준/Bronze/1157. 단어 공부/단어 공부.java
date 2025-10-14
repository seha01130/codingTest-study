import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // toLowerCase()까지는 동일
        String line = br.readLine();
        if (line == null || line.isEmpty()) {
            // 혹시 모를 빈 입력에 대한 방어 코드
            return;
        }
        
        char[] arr = line.toLowerCase().toCharArray();

        // HashMap으로 빈도수 세는 부분은 동일
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 리스트로 변환하고 정렬하는 부분은 동일
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // --- 로직 수정 부분 ---
        // 가장 빈번한 문자가 여러 개인지 확인
        if (list.size() > 1 && list.get(0).getValue().equals(list.get(1).getValue())) {
            // 조건: 리스트에 2개 이상 있고, 1등과 2등의 빈도수가 같으면
            System.out.println("?");
        } else {
            // 그 외 모든 경우 (항목이 1개이거나, 1등의 빈도수가 2등보다 클 때)
            System.out.println(Character.toUpperCase(list.get(0).getKey()));
        }
    }
}
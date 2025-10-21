import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String input = br.readLine();
        Map<Character, Integer> hm = new HashMap<Character, Integer>();
        for(char c: input.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(hm.entrySet());
        list.sort((a, b) -> a.getKey().compareTo(b.getKey()));

        int count = 0;
        char middle = 0;
        for (Map.Entry<Character, Integer> entry : list){
            if (entry.getValue() % 2 != 0){
                count++;
                middle = entry.getKey(); // 가운데 값 확보
                entry.setValue(entry.getValue() - 1); //갯수 하나 빼서 짝수로 만듦
                if (count > 1){
                    sb.append("I'm Sorry Hansoo");
                    System.out.print(sb);
                    return;
                }
            }
        }

        String str = "";
        for (Map.Entry<Character, Integer> entry : list){
            Character tmp = entry.getKey();
            if (entry.getValue() == 0){
                continue;
            }
            for (int i = 0; i < entry.getValue() / 2; i++){
                str += tmp;
            }
        }

        String str2= "";
        for(int i = 1; i <= str.length(); i++){
            str2 += str.charAt(str.length() - i);
        }

        sb.append(str);
        if (middle != 0){
            sb.append(middle);
        }
        sb.append(str2);

        System.out.print(sb);
    }
}

/*
 * 홀수개인건 무조건 하나. 만약 아니라면 아임쏘리
 * 갯수 빼서 짝수로 만들자. 갯수 하나 뺸거 그거는 무조건 가운데에 위치하게 함.
 * 나머지는 다 짝수개여야 함
 * 
 * 짝수개인거를(모든알파벳이겠죠) 알파벳순으로 1/2 개만큼 위치시킴
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        ArrayList<String> enterPeople = new ArrayList<>();

        HashMap<String, String> hm = new HashMap<>();
        for(int i = 0; i < num; i++){
            String[] str = br.readLine().split(" ");
            hm.put(str[0], str[1]);
        }

        Set<Map.Entry<String, String>> entrySet = hm.entrySet();
        Iterator<Map.Entry<String, String>> itr = entrySet.iterator();

        while (itr.hasNext()) {
            Map.Entry<String, String> eachEntry = itr.next();
            if (eachEntry.getValue().equals("enter")){
                enterPeople.add(eachEntry.getKey());
            }
        }

        Collections.sort(enterPeople, Collections.reverseOrder());

        br.close();
        for(String s : enterPeople){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
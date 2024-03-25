import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        HashMap<String, String> enterPeople = new HashMap<>();

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i < num; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String log = st.nextToken();

            if (!enterPeople.containsKey(name)){ //HashMap에 해당 사람이 없으면(enter을 안했으면) put
                enterPeople.put(name, log);
            }
            else { //HashMap에 해당 사람이 있으면(enter을 했으면) remove
                enterPeople.remove(name);
            }
        }

        ArrayList<String> result = new ArrayList<>(enterPeople.keySet());
        Collections.sort(result, Collections.reverseOrder());

        br.close();
        for(String s : result){
            sb.append(s).append("\n");
        }
        System.out.println(sb);
    }
}
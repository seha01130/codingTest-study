import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int listenNum;
        int seeNum;

        String[] inputs = br.readLine().split(" ");
        listenNum = Integer.parseInt(inputs[0]);
        seeNum = Integer.parseInt(inputs[1]);

        //듣도보도 못한 사람 저장할 ArrayList
        ArrayList<String> result = new ArrayList<>();

        //듣도 못한 사람 입력받기
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < listenNum; i++){
            set.add(br.readLine());
        }

        //보도 못한 사람 입력받으면서 듣도 못한 사람도 해당되면 결과에 add
        for(int i = 0; i < seeNum; i++){
            String str = br.readLine();
            if(set.contains(str)){
                result.add(str);
            }
        }

        Collections.sort(result);

        sb.append(result.size());
        sb.append("\n");
        for(String s : result){
            sb.append(s + "\n");
        }

        System.out.println(sb);
    }
}
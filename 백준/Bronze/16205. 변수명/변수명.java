import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();

        String[] input = br.readLine().split(" ");
        int number = Integer.parseInt(input[0]);

        List<Character> strList = new ArrayList<>();
        List<Character> strList2 = new ArrayList<>();
        for (char c : input[1].toCharArray()){
            strList.add(c);
            strList2.add(c);
        }

        String[] answer = new String[3];

        if (number == 1) {
            answer[0] = input[1];
            for(int i = 0; i < strList.size(); i++){
                if (Character.isUpperCase(strList.get(i))){
                    strList.add(i, '_');
                    strList.set(i + 1, Character.toLowerCase(strList.get(i+1)));
                    i++;
                }
            }
            answer[1] = listToString(strList);
            answer[2] = CapitalizeFirstWord(answer[0]);
            
        }else if (number == 2) {
            answer[1] = input[1];
            for(int i = 0; i < strList.size(); i++){
                if (strList.get(i) == '_'){
                    for (int j = i; j < strList.size() - 1; j++){
                        strList.set(j, strList.get(j + 1));
                    }
                    strList.remove(strList.size() - 1);
                    strList.set(i, Character.toUpperCase(strList.get(i)));
                }
            }
            answer[0] = listToString(strList);
            answer[2] = CapitalizeFirstWord(answer[0]);
        }else {
            answer[2] = input[1];
            strList.set(0, Character.toLowerCase(strList.get(0)));
            answer[0] = listToString(strList);

            for(int i = 0; i < strList.size(); i++){
                if (Character.isUpperCase(strList.get(i))){
                    strList.add(i, '_');
                    strList.set(i + 1, Character.toLowerCase(strList.get(i+1)));
                    i++;
                }
            }
            answer[1] = listToString(strList);
        }

        sb.append(answer[0]).append('\n').append(answer[1]).append('\n').append(answer[2]);
        System.out.println(sb);
    }

    private static String listToString(List<Character> list){
        StringBuilder sb= new StringBuilder();
        for (char c : list){
            sb.append(c);
        }
        return sb.toString();
    }

    private static String CapitalizeFirstWord(String str){
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }
}

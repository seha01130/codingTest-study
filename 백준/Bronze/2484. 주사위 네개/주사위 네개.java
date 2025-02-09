import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        String[] strings;
        int answer = 0;
        for(int i = 0; i < num; i++){
            strings = br.readLine().split(" ");
            
            HashMap<Integer, Integer> counts = new HashMap<>();
            int count = 0;
            for (int j = 1; j <= 6; j++){
                for (String s : strings){
                    if (j == Integer.parseInt(s)){
                        count++;
                    }
                }
                counts.put(j, count);
                count = 0;
            }

            // System.out.println(counts);
            
            int diceNum = 0;
            int DoubleTwoNum = 0;
            int maxPrice = 0;
            int price = 0;

            Set<Map.Entry<Integer, Integer>> entrySet = counts.entrySet();
            Iterator<Map.Entry<Integer, Integer>> itr = entrySet.iterator();
            Integer twoDouble[] = new Integer[2];
            while(itr.hasNext()){
                Map.Entry<Integer, Integer> eachEntry = itr.next();
                // System.out.println("밸류값 : " + eachEntry.getValue());
                if (eachEntry.getValue() == 4){
                    diceNum = eachEntry.getKey();
                    price = 50000 + diceNum * 5000;
                    // break;
                } else if (eachEntry.getValue() == 3){
                    diceNum = eachEntry.getKey();
                    price = 10000 + diceNum * 1000;
                    // break;
                } else if (eachEntry.getValue() == 2){
                    twoDouble[DoubleTwoNum] = eachEntry.getKey();
                    
                    if (DoubleTwoNum == 0) {
                        price = 1000 + eachEntry.getKey() * 100;
                    } else {
                        price = 2000 + twoDouble[0] * 500 + twoDouble[1] * 500;
                        // break;
                    }

                    DoubleTwoNum++;
                } else if (eachEntry.getValue() == 1){
                    diceNum = eachEntry.getKey();
                    price = diceNum * 100;
                }

                if (price > maxPrice){
                    maxPrice = price;
                }
            }

            if (maxPrice > answer){
                answer = maxPrice;
            }
        }

        sb.append(answer);
        System.out.println(sb);
    }
}

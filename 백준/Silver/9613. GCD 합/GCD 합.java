//챗지피티 코드인데 ㄹㅇ 맞는지 확인할라고 돌림

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            long sum = 0; // GCD 합이 int 범위를 넘을 수 있어 long 사용
            for (int j = 0; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    sum += getGCD(list.get(j), list.get(k));
                }
            }

            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

    public static int getGCD(int a, int b){
        while (b != 0){
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}

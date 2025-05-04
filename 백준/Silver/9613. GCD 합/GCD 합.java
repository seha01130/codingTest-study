import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());

        int n;
        StringTokenizer st;
        ArrayList<Integer> list = new ArrayList<>();
    
        for (int i = 0; i < t; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            //확실하게 n개 읽음
            for (int j = 0; j < n; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }

            //불확실함...
            // while(st.hasMoreTokens()){
            //     list.add(Integer.parseInt(st.nextToken()));
            // }

            long sum = 0; //합이 클 수도 있으니까 long 사용
            for (int j = 0; j < n - 1; j++){

                for (int k = j + 1; k < n; k++){
                    // 유클리드 호제법(GCD 알고리즘)은 어떤 순서로 두 숫자를 넘기든 상관없이 작동
                    // 유클리드 호제법은 두 수의 순서에 영향을 받지 않습니다.
                    // 굳이 큰수/작은수 구분하지 않아도 됩니다 불필요하게 Math.max, Math.min을 사용할 필요가 없음
                    // 오히려 그 연산이 성능을 소폭 떨어뜨립니다.

                    /* 반례 예시로 검증
getGCD(2, 10); // 2가 작음
// a=2, b=10
// temp = 2 % 10 = 2
// a = 10, b = 2
// temp = 10 % 2 = 0
// 종료 → GCD는 2

getGCD(10, 2); // 10이 큼
// a=10, b=2
// temp = 10 % 2 = 0
// 종료 → GCD는 2
                    결과는 동일하다
                    */

                    sum += getGCD2(list.get(j), list.get(k));
                }
            }

            if (i < t - 1){
                sb.append(sum).append("\n");
            } else {
                sb.append(sum);
            }

            list.clear();
        }

        System.out.print(sb);
    }

    // public static int getGCD(int a, int b){
    //     while (b != 0){
    //         int tmp = a % b;
    //         a = b;
    //         b = tmp;
    //     }

    //     return a;
    // }

    public static int getGCD2(int a, int b){
        if (b == 0){
            return a;
        }

        return getGCD2(b, a % b);
    }
}

/*
 * 유클리드 알고리즘 원리
유클리드 알고리즘에서 큰 수를 작은 수로 나누면서 나머지를 구하고, 그 나머지와 작은 수를 다시 나누는 방식입니다. 이 방식에 따라,
원래 getGCD(a, b)는 a가 더 크거나 같다는 가정 하에 b % a를 계산합니다.
 */
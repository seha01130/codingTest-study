import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < N; i++){
            list.add(Integer.parseInt(br.readLine()));
        }

        //내림차순
        list.sort(Comparator.reverseOrder());

        int a, b, c;
        // ArrayList.get(index)는 범위를 벗어나면 null이 아니라 예외를 던짐.
        for (int i = 0; i < list.size() - 2; i++){
            int[] array = new int[3];
            array[0] = list.get(i);
            array[1] = list.get(i + 1);
            array[2] = list.get(i + 2);

            Arrays.sort(array);

            a = array[0];
            b = array[1];
            c = array[2];

            // System.out.println(Arrays.toString(array));

            if (a + b > c) {
                System.out.println(a + b + c);
                return;
            }
        }

        System.out.println(-1);
    }
}
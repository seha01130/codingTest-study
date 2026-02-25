import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int length = str.length();

        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = str.charAt(i) - '0';
        }
        // System.out.println(Arrays.toString(arr));

        int count = 1;
        for (int i = 0; i < length; ){
            String s = Integer.toString(count);
            for (int j = 0; j < s.length(); j++){
                if(s.charAt(j) - '0' == arr[i]){
                    i++;

                    if (i == length){
                        System.out.println(count);
                        return;
                    }
                }
            }
            count++;
        }

    }
}
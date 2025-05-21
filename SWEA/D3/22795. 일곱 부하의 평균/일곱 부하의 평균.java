import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int[] arr = new int[6];
			int sum = 0;
			int max = 0;
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i = 0; i < 6; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				sum += arr[i];
				if (arr[i] > max) {
					max = arr[i];
				}
			}
			// ---------------- 6명 키 입력 완료, 6명 키 합sum 구함, 젤 큰 키 구함
			
			int height = max + 1;
			while ((sum + height) % 7 != 0) {
				height++;
			}
			
			sb.append(height).append("\n");
		}
		
		System.out.println(sb);
	}
}

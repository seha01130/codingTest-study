import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
//		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < 10; testCase++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] arr = new int[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			// ------------- 건물높이 입력 완료
//			System.out.println(Arrays.toString(arr));
			
			int count = 0;
			for (int i = 2; i < N - 2; i++) {
				int leftMax = Math.max(arr[i-1], arr[i-2]);
				int rightMax = Math.max(arr[i+1], arr[i+2]);
				
				if (arr[i] - leftMax < 0 || arr[i] - rightMax < 0) {
					continue;
				}
				
				int safe = Math.min(arr[i] - leftMax, arr[i] - rightMax);
				
				count += safe;
			}
			String str = "#" + (testCase + 1) + " " + count;
			sb.append(str).append("\n");
		}
		
		System.out.println(sb);
	}
}

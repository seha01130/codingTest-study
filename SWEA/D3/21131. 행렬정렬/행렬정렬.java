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
			int N = Integer.parseInt(br.readLine());
			
			int[][] arr = new int[N][N];
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// ------------ 행렬 삽입 완료
			
			int count = 0;
			boolean transpose = false; //전치안함 상태로 초기화
			for (int i = N; i >= 2; i--) {
				int expected = i;
				int actual = transpose? arr[i - 1][0] : arr[0][i - 1];
				
				if (expected != actual) { //상태변경 해줘야함
					transpose = !transpose;
					count++;
				}
			}
			
			System.out.println(count);
		}
	}
}

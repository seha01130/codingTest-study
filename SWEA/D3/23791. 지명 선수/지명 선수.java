import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 0; testCase < T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			Deque<Integer> dequeA = new ArrayDeque<>();
			Deque<Integer> dequeB = new ArrayDeque<>();
			
			StringTokenizer st;
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				dequeA.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < N; i++) {
				dequeB.add(Integer.parseInt(st.nextToken()));
			}
			// ------------------------------배열에 선호 선수 넣기 완료
			
			char[] result = new char[N + 1]; // 정답 넣을 문자배열
//			System.out.println(Arrays.toString(result));
			
			for (int j = 1; j <= N / 2 + 1; j++) {
				
				//A 뽑아
				int flag = 0;
				while (flag == 0) {
					if (dequeA.isEmpty()) {
						break;
					}
					
					if (result[dequeA.peekFirst()] == 0) { //아직 뽑히지 않은 애
						result[dequeA.peekFirst()] = 'A';
						dequeA.removeFirst();
						flag = 1;
					} else {								//이미 뽑힌애야
						dequeA.removeFirst();
					}
				}

				//B 뽑아
				flag = 0;
				while (flag == 0) {
					if (dequeB.isEmpty()) {
						break;
					}
					
					if (result[dequeB.peekFirst()] == 0) { //아직 뽑히지 않은 애
						result[dequeB.peekFirst()] = 'B';
						dequeB.removeFirst();
						flag = 1;
					} else {								//이미 뽑힌애야
						dequeB.removeFirst();
					}
				}
			}
			
			for (int i = 1; i <= N; i++) {
				sb.append(result[i]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}

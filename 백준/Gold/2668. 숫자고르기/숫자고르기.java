import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 1; i <= N; i++){
            int input = Integer.parseInt(br.readLine());
            graph[i].add(input);
        }
        // 그래프 연결 끝

        // boolean[] visited = new boolean[N+1];
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 1; i <= N; i++){
            int flag = 1;
            boolean[] visited = new boolean[N+1];

            int first = i;
            int second = graph[first].get(0);

            while (second != i){

                if (visited[second]){
                    flag = 0;
                    break;
                }   

                visited[second] = true;

                second = graph[second].get(0);
            }

            if (flag == 1){
                answer.add(i);
            }

        }
        
        sb.append(answer.size()).append("\n");
        for (int i = 0; i < answer.size(); i++){
            sb.append(answer.get(i)).append("\n");
        }

        
        System.out.println(sb);
    }
}

/*
// 처음 생각
2개~N개 조합을 쭉 뽑으면서 검사
그러니까 1~N 까지 돌면서 2개씩 뽑는 조합을 검사하고 그다음은 1~N까지 돌면서 3개씩 뽑는 조합을 검사하고,,, 이걸 N개씩 뽑는 조합까지 검사
N개 중에 2개를 뽑고, 3개를 뽑고... 이렇게 모든 조합을 다 확인
-> N은 최대 100 -> 100개 중 몇 개를 뽑는 모든 경우의 수는 2^100 -> 시간초과!!!

// 올바른 설계
1이 3을 가리키고 2가 1을 가리키고 3이 1을 가리킨다고 생각하자. 즉, 첫줄의 수가 두번째줄의 수를 가리킨다고 생각하자.
1이 3을 가리킬 때, 3은 또 1을 가리키고 있다. 즉, 1 -> 3 -> 1 이런 순환구조가 생김. 그럼 1과 3은 뽑아야하는 수인 것!!!
-> 내가 어떤 숫자를 골랐을 때, 그 숫자들이 위아래 세트가 똑같으려면 출발한 숫자가 결국 다시 자기 자신으로 돌아와야 합니다. 즉, 사이클에 포함된 숫자들만 우리가 고를 수 있는 숫자가 되는 것이죠!
!!! 1 -> 3 -> 2 -> 1 이럴수도 있음 !!!

!!! 1 -> 3 -> 2 -> 3 -> 2 이럴수도 있음 !!!


이 문제는 일반적인 그래프와 다른 아주 큰 특징이 있습니다.

"모든 숫자가 단 하나의 화살표만 가진다."

이 말은 갈림길이 없다는 뜻입니다. 그냥 쭉 따라가기만 하면 돼요. 이런 경우에는 복잡한 Stack 객체보다 재귀 함수나 단순한 while문이 훨씬 강력합니다.
*/
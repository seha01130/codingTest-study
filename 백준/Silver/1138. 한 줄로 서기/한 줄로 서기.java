import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
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
        int[] inputArr = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            inputArr[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> answerList = new ArrayList<>();

        for (int i = N; i >= 1; i--){
            int tallerNum = inputArr[i];
            answerList.add(tallerNum, i);
        }

        for (int i = 0; i < N; i++){
            sb.append(answerList.get(i)).append(" ");
        }
        
        System.out.println(sb);
    }
}

/*
1번째 방법
n개의 배열 마련해놓고
키 작은사람부터 확인하면서 자기보다 큰 사람의 수만큼 빈 공간 두고 그 다음칸에 넣기.
앞으로 확인할 사람은 나보다 큰 사람이니까 그 사람이 들어갈 공간을 앞에 둬놓는거야.

2번째 방법
ArrayList로 중간에 끼어들 수 있게 정답 받음
키 큰 사람부터 확인하면서 자기보다 큰 사람의 수를 index로 하여 ArrayList에 끼워넣기 함.
-> 큰 사람부터 확인하니까 어차피 다음에 나올 사람은 나보다 작은 사람임. 그럼 나보다 큰 사람의 수에 영향을 주는 사람이 이후에 없을거라는 뜻.
-> 따라서 자기보다 큰 사람의 수를 index로 하면 나중에 내 앞에 끼어드는 사람이 있다고 해도 여전히 나보다 큰 사람의 수는 동일함.
(ArrayList 자료구조를 쓴 이유임! 중간에 인덱스가 끼어들어도 그 뒤는 알아서 자연스럽게 뒤로 밀리니까!)
*/
import java.util.*;

class Solution {
    static HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        char[] charArr = numbers.toCharArray();
        int[] arr = new int[charArr.length];
        for(int i = 0; i < charArr.length; i++){
            arr[i] = charArr[i] - '0';
        }
        // System.out.println(Arrays.toString(arr));
        
        int[] number = new int[arr.length];
        boolean[] visited = new boolean[arr.length];
        int answer = 0;
        for (int i = 0; i < arr.length; i++){
            permutation(arr, number, visited, 0, i+1, 0);
        }
        return set.size();
    }
    
    public static int permutation(int[] arr, int[] number, boolean[] visited, int depth, int r, int count){
        if (depth == r){
            int num = 0;
            for (int i = 0; i < depth; i++){
                num = num * 10 + number[i];
            }
            
            if (isPrimeNumber(num)){
                set.add(num);
            }
        }
        
        for (int i = 0; i < arr.length; i++){
            if (visited[i]) continue;
            
            visited[i] = true;
            number[depth] = arr[i];
            count = permutation(arr, number, visited, depth+1, r, count);
            visited[i] = false;
        }
        return count;
    }
    
    public static boolean isPrimeNumber(int num){
        if (num < 2) return false;
        if (num == 2) return true;
        
        for (int i = 2; i * i <= num; i++){
            if (num % i == 0) return false;
        }
        return true;
    }
}
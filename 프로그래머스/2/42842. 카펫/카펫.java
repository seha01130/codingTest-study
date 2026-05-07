class Solution {
    public int[] solution(int brown, int yellow) {
        int y_w = 0;
        int y_h = 0;
        for (int i = yellow; ; i--){
            if (yellow % i != 0) continue;
            y_w = i;
            y_h = yellow / i;
            if (y_h > y_w) break;
            
            if ((y_w + 2) * 2 + y_h * 2 == brown) break;
        }
        
        int[] answer = {y_w+2, y_h+2};
        
        return answer;
    }
}

/*
노란색의 가로+2가 갈색의 가로
노란색의 세로+2가 갈색의 세로

(노란색 가로+2) * 2 + 노란색 세로 * 2 = 갈색타일의 갯수


*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int money = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 0 : 현재 남은 금액, 1: 주식 수
        int[] JH = {money, 0};
        int[] SM = {money, 0};
        
        int[] price = new int[14];
        for (int i = 0; i < 14; i++){
            price[i] = Integer.parseInt(st.nextToken());
        }

        // 성민이를 위한 상승하락 여부
        int upCount = 0;
        int downCount = 0;

        // 계산
        for (int i = 0; i < 14; i++){
            int todayP = price[i]; // 오늘 주가
            int buyWeek = 0;       // 매수한 주 수

            // 준환
            if (todayP <= JH[0]){
                buyWeek = JH[0] / todayP;
                JH[1] += buyWeek;
                JH[0] -= todayP * buyWeek;
            }

            // 성민
            if (i == 0) continue;

            if (price[i] > price [i-1]){
                upCount++;
                downCount = 0;
            } else if (price[i] < price [i-1]) {
                downCount++;
                upCount = 0;
            }

            if (upCount == 3){
                SM[0] += SM[1] * todayP;
                SM[1] = 0;
            }
            if (downCount == 3){
                buyWeek = SM[0] / todayP;
                SM[1] += buyWeek;
                SM[0] -= buyWeek * todayP;
            }
        }

        int JHResult = JH[0] + price[13] * JH[1];
        int SMResult = SM[0] + price[13] * SM[1];

        if (JHResult > SMResult){
            sb.append("BNP");
        } else if (JHResult < SMResult){
            sb.append("TIMING");
        } else {
            sb.append("SAMESAME");
        }

        System.out.println(sb);
    }
}

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

    static class Player implements Comparable<Player> {
        int level;
        String nickname;

        Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }

        @Override
        public int compareTo(Player o){
            return this.nickname.compareTo(o.nickname);
        }
    }

    static class Room {
        int baseLevel;
        int compacity;
        ArrayList<Player> players = new ArrayList<>();

        Room(int baseLevel, String nickname, int compacity){
            this.baseLevel = baseLevel;
            this.compacity = compacity;
            players.add(new Player(baseLevel, nickname));
        }

        void join(int level, String nickname) {
            players.add(new Player(level, nickname));
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Room> rooms = new ArrayList<>();

        for (int i = 0; i < p; i++){
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            boolean joinRoom = false;
            for(Room room : rooms){
                if (room.players.size() < m && Math.abs(room.baseLevel - level) <= 10) {
                    room.join(level, nickname);
                    joinRoom = true;
                    break;
                }
            }

            if (!joinRoom){
                rooms.add(new Room(level, nickname, m));
            }
        }

        for (Room room : rooms){
            if (room.players.size() == m) sb.append("Started!\n");
            else sb.append("Waiting!\n");

            Collections.sort(room.players);

            for (Player player : room.players){
                sb.append(player.level).append(" ").append(player.nickname).append("\n");
            }
        }
        
        System.out.println(sb);
    }
}

/*
각 방 별 기준 점수 기록 필요 -> 처음으로 방 들어온 사람(생성한 사람)
새로운사람 들어올때마다 방 돌면서 빈자리있고, 기준 점수에서 -+10인지 보고 맞으면 넣고, 아니면 방 새로 만들기

방1 (기준레벨, 인원수)
- 레벨 / 닉넴
- 레벨 / 닉넴
...

방2 (기준레벨, 인원수)
- 레벨 / 닉넴
- 레벨 / 닉넴
...

방과 멤버를 class로 빼기 -> Room, Player
*/
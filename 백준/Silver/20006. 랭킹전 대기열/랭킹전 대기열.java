import java.io.*;
import java.util.*;

class Player implements Comparable<Player> {
    int level;
    String nickname;

    public Player(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }

    @Override
    public int compareTo(Player p) {
        return this.nickname.compareTo(p.nickname);
    }
}

public class Main {
    static ArrayList<ArrayList<Player>> channel = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken()); // 플레이어 수
        int m = Integer.parseInt(st.nextToken()); // 방의 정원

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();

            Player player = new Player(level, nickname);

            boolean valid = false; // 입장 여부

            for (ArrayList<Player> r : channel) {
                int masterLevel = r.get(0).level;
                if ((level >= masterLevel - 10 && level <= masterLevel + 10) && r.size() < m) {
                    r.add(player);
                    valid = true;
                    break;
                }
            }

            // 방에 입장하지 못했다면 새로운 방 생성
            if (!valid) {
                ArrayList<Player> room = new ArrayList<>();
                room.add(player);
                channel.add(room);
            }
        }

        for (ArrayList<Player> r: channel) {
            Collections.sort(r);
            if (r.size() == m) {
                bw.write("Started!\n");
            } else {
                bw.write("Waiting!\n");
            }
            for (Player player : r) {
                bw.write(player.level + " " + player.nickname + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

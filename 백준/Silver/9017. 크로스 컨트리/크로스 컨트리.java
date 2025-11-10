import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> teams = new HashMap<>();
            int[] rank = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < n; j++) {
                int team = Integer.parseInt(st.nextToken());
                rank[j] = team;
                teams.put(team, teams.getOrDefault(team, 0) + 1);
            }

            HashMap<Integer, ArrayList<Integer>> scores = new HashMap<>();
            for (Map.Entry<Integer, Integer> entry : teams.entrySet()) {
                if (entry.getValue() == 6) {
                    scores.put(entry.getKey(), new ArrayList<>());
                }
            }

            int score = 1;
            for (int j=0; j<n; j++) {
                if (scores.containsKey(rank[j])) {
                    scores.get(rank[j]).add(score);
                    score++;
                }
            }

            int winner = 0;
            int min = Integer.MAX_VALUE;
            int fifth = 0; // 우승팀의 다섯 번째 선수의 점수

            for (Map.Entry<Integer, ArrayList<Integer>> entry : scores.entrySet()) {
                int s = 0;
                for (int j=0; j<4; j++) {
                    s += entry.getValue().get(j);
                }
                if (s < min) {
                    min = s;
                    winner = entry.getKey();
                    fifth = entry.getValue().get(4);
                } else if (s == min) {
                    if (entry.getValue().get(4) < fifth) {
                        winner = entry.getKey();
                        fifth = entry.getValue().get(4);
                    }
                }
            }

            bw.write(winner + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

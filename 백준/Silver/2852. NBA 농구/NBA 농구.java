import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int score1 = 0;
        int score2 = 0;

        int n = Integer.parseInt(br.readLine()); // 골이 들어간 횟수

        int totalTime = 60 * 48;

        int lastLeadTime = 0;

        int team1LeadTime = 0;
        int team2LeadTime = 0;

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int num = Integer.parseInt(st.nextToken());

            String[] timeStr = st.nextToken().split(":");

            int time = Integer.parseInt(timeStr[0]) * 60 + Integer.parseInt(timeStr[1]);

            if (score1 > score2) {
                team1LeadTime += (time - lastLeadTime);
            } else if (score1 < score2) {
                team2LeadTime += (time - lastLeadTime);
            }

            if (num == 1) {
                score1 += 1;
            } else {
                score2 += 1;
            }
            
            lastLeadTime = time;
        }

        if (score1 > score2) {
            team1LeadTime += totalTime - lastLeadTime;
        } else if (score1 < score2) {
            team2LeadTime += totalTime - lastLeadTime;
        }

        int min1 = team1LeadTime / 60;
        int sec1 = team1LeadTime % 60;
        int min2 = team2LeadTime / 60;
        int sec2 = team2LeadTime % 60;

        System.out.printf("%02d:%02d\n", min1, sec1);
        System.out.printf("%02d:%02d\n", min2, sec2);

        br.close();
    }
}

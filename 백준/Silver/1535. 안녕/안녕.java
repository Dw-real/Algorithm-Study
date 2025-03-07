import java.io.*;
import java.util.*;

public class Main {
    static int[][] info; // 각각의 사람에게 인사할 때 잃는 체력과 얻는 기쁨
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 사람의 수
        info = new int[n + 1][2];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        // 잃는 체력
        for (int i=1; i<=n; i++) {
            info[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine(), " ");

        // 얻는 기쁨
        for (int i=1; i<=n; i++) {
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n + 1][100]; // n명에게 인사 했을 때 잃은 체력별 최대 기쁨

        int max = 0;

        for (int i=1; i<=n; i++) {
            int life = info[i][0];
            int joy = info[i][1];

            for (int j=1; j<100; j++) {
                if (j < life) { // 잃는 life가 더 큰 경우 -> 인사 불가능
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - life] + joy);
                }
                max = Math.max(max, dp[i][j]);
            }
        }

        bw.write(max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
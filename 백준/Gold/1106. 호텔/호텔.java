import java.io.*;
import java.util.*;

public class Main {
    static int[] dp;
    static int[][] info; // 홍보할 때 드는 비용과 그 비용으로 얻을 수 있는 고객의 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int c = Integer.parseInt(st.nextToken()); // 늘려야하는 최소 고객 수
        int n = Integer.parseInt(st.nextToken()); // 홍보할 수 있는 도시의 수

        dp = new int[c + 101];
        Arrays.fill(dp, 10000001);
        dp[0] = 0;
        info = new int[n + 1][2];

        for (int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            info[i][0] = Integer.parseInt(st.nextToken()); // 비용
            info[i][1] = Integer.parseInt(st.nextToken()); // 고객의 수
        }

        for (int i=1; i<c + 101; i++) {
            for (int j=1; j<=n; j++) {
                int cost = info[j][0];
                int people = info[j][1];

                if (i == people)
                    dp[i] = Math.min(dp[i], cost);
                else if (i >= people)
                    dp[i] = Math.min(dp[i], dp[i - people] + cost);
            }
        }

        int min = Integer.MAX_VALUE;

        for (int i=c; i<c + 101; i++) {
            min = Math.min(min, dp[i]);
        }

        bw.write(min + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
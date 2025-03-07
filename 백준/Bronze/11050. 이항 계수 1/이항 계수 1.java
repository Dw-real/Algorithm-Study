import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n + 1][n + 1];
        for (int i=0; i<=n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
            for (int j=0; j<=n; j++) {
                if (i == j)
                    dp[i][j] = 1;
            }
        }

        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }

        bw.write(dp[n][k] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}

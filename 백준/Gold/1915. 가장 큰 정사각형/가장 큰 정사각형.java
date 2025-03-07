import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;

    static int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[n][m];

        for (int i=0; i<n; i++) {
            String str = br.readLine();
            for (int j=0; j<m; j++) {
                dp[i][j] = str.charAt(j) - '0';
            }
        }

        int max = -1;
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (dp[i][j] == 1 && i >= 1 && j>=1)
                    dp[i][j] = getMin(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
                if (max < dp[i][j])
                    max = dp[i][j];
            }
        }

        bw.write(max * max + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
